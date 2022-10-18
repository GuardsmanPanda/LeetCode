package Problem2300;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem2378 {
    public long maxScore(int[][] edges) {
        int[] inDegree = new int[edges.length];
        for (int[] edge : edges) {
            if (edge[0] != -1) {
                inDegree[edge[0]]++;
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        long[] included = new long[edges.length];
        long[] excluded = new long[edges.length];
        while (queue.size() > 0) {
            int node = queue.poll();
            int[] edge = edges[node];
            System.out.println("node: " + node + ", edge: " + Arrays.toString(edge));
            System.out.println("included: " + Arrays.toString(included));
            System.out.println("excluded: " + Arrays.toString(excluded));
            if (edge[0] == -1) {
                return included[node];
            }
            int p = edge[0], w = edge[1];
            included[p] = Math.max(included[p] + included[node], excluded[p] + w + excluded[node]);
            excluded[p] += included[node];
            if (--inDegree[p] == 0) {
                queue.add(p);
            }
        }
        return 0;
    }
}
