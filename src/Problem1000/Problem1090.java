package Problem1000;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Map<Integer, Integer> labelUsage = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            pq.add(new int[]{values[i], labels[i]});
        }
        int res = 0;
        while (pq.size() > 0 && numWanted-- > 0) {
            while (pq.size() > 0 && labelUsage.compute(pq.peek()[1], (k, v) -> v == null ? 1 : v + 1) > useLimit) {
                pq.poll();
            }
            res += pq.size() > 0 ? pq.poll()[0] : 0;
        }
        return res;
    }
}
