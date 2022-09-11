package Problem1000;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem1086 {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            var q = map.computeIfAbsent(item[0], k -> new PriorityQueue<>());
            q.add(item[1]);
            if (q.size() > 5) {
                q.remove();
            }
        }
        int[][] result = new int[map.size()][2];
        int i = 0;
        for (var entry : map.entrySet()) {
            result[i][0] = entry.getKey();
            result[i++][1] = entry.getValue().stream().mapToInt(Integer::intValue).sum() / entry.getValue().size();
        }
        return result;
    }
}
