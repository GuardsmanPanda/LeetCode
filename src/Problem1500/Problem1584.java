package Problem1500;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1584 {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // Add all edges between all points to queue based on manhatten distance
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                queue.add(new int[]{i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});
            }
        }
        // Use union find to find the minimum cost of connecting all points
        int[] parent = new int[points.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int cost = 0;
        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);
            if (p1 != p2) {
                parent[p1] = p2;
                cost += edge[2];
            }
        }

        return cost;
    }

    private int find(int[] parent, int i) {
        return parent[i] == i ? i : (parent[i] = find(parent, parent[i]));
    }
}
