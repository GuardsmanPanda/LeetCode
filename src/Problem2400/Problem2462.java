package Problem2400;

import java.util.PriorityQueue;

public class Problem2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int left = 0, right = costs.length - 1;
        while (left < candidates) {
            heap.add(new int[]{costs[left], left++, 0});
        }
        while (left <= right && heap.size() < candidates * 2) {
            heap.add(new int[]{costs[right], right--, 1});
        }
        long total = 0;
        for (int i = 0; i < k; i++) {
            int[] top = heap.remove();
            total += top[0];
            if (left <= right && top[2] == 0) {
                heap.add(new int[]{costs[left], left++, 0});
            } else if (left <= right && top[2] == 1) {
                heap.add(new int[]{costs[right], right--, 1});
            }
        }
        return total;
    }
}
