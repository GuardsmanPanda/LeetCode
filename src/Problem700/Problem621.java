package Problem700;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem621 {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> taskQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (taskCount[i] > 0) {
                taskQueue.add(new int[]{taskCount[i], 0});
            }
        }
        PriorityQueue<int[]> busyQueue = new PriorityQueue<>((a, b) -> b[1] == a[1] ? b[0] - a[0] : a[1] - b[1]);
        int time = 0;
        while (taskQueue.size() > 0 || busyQueue.size() > 0) {
            while (busyQueue.size() > 0 && busyQueue.peek()[1] <= time) {
                taskQueue.add(busyQueue.remove());
            }
            if (taskQueue.isEmpty()) {
                taskQueue.add(busyQueue.remove());
            }
            int[] task = taskQueue.remove();
            time = Math.max(time + 1, task[1] + 1);
            task[0]--;
            task[1] = time + n;
            if (task[0] > 0) {
                busyQueue.add(task);
            }
        }
        return time;
    }
}
