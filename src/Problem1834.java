import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1834 {
    public int[] getOrder(int[][] tasks) {
        int[][] orderedTasks = new int[tasks.length][];
        for (int i = 0; i < tasks.length; i++) {
            orderedTasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(orderedTasks, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int[] res = new int[orderedTasks.length];
        int time = orderedTasks[0][0];
        int idx = 0;
        int rdx = 0;
        while (idx < orderedTasks.length) {
            while (idx < orderedTasks.length && orderedTasks[idx][0] <= time) {
                queue.add(new int[]{orderedTasks[idx][0], orderedTasks[idx][1], orderedTasks[idx++][2]});
            }
            if (queue.isEmpty()) {
                time = orderedTasks[idx][0];
                while (idx < orderedTasks.length && orderedTasks[idx][0] <= time) {
                    queue.add(new int[]{orderedTasks[idx][0], orderedTasks[idx][1], orderedTasks[idx++][2]});
                }
            }
            int[] task = queue.remove();
            time += task[1];
            res[rdx++] = task[2];
        }
        while (!queue.isEmpty()) {
            res[rdx++] = queue.remove()[2];
        }
        return res;
    }
}
