package Problem1800;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Problem1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        TreeSet<int[]> available = new TreeSet<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < servers.length; i++) {
            available.add(new int[]{i, servers[i], 0});
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[] res = new int[tasks.length];
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (available.isEmpty()) {
                time = busy.peek()[2];
            }
            time = Math.max(time, i);
            while (busy.size() > 0 && busy.peek()[2] <= time) {
                available.add(busy.remove());
            }
            int[] server = available.pollFirst();
            server[2] = time + tasks[i];
            res[i] = server[0];
            busy.add(server);
        }
        return res;
    }
}
