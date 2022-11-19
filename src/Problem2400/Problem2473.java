package Problem2400;

import java.util.*;

public class Problem2473 {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0] - 1).add(new int[]{road[1] - 1, road[2] + road[2] * k});
            graph.get(road[1] - 1).add(new int[]{road[0] - 1, road[2] + road[2] * k});
        }
        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
            long[] minCost = new long[n];
            Arrays.fill(minCost, Long.MAX_VALUE);
            queue.add(new long[]{i, 0});
            minCost[i] = 0;
            long totalAppleCost = appleCost[i];
            while (queue.size() > 0) {
                long[] node = queue.remove();
                totalAppleCost = Math.min(totalAppleCost, appleCost[(int)node[0]] + node[1]);
                graph.get((int)node[0]).forEach(neighbor -> {
                    if (minCost[neighbor[0]] > node[1] + neighbor[1]) {
                        minCost[neighbor[0]] = node[1] + neighbor[1];
                        queue.add(new long[]{neighbor[0],  minCost[neighbor[0]]});
                    }
                });
            }
            result[i] = totalAppleCost;
        }
        return result;
    }
}
