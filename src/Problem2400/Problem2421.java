package Problem2400;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2421 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(e -> Math.max(vals[e[0]], vals[e[1]])));
        int[] parent = new int[vals.length];
        int[] value = new int[vals.length];
        int[] size = new int[vals.length];
        for (int i = 0; i < parent.length; i++) {
            value[i] = vals[i];
            parent[i] = i;
            size[i] = 1;
        }
        int res = 0;
        for (int[] edge : edges) {
            int max = Math.max(vals[edge[0]], vals[edge[1]]);
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);
            if (value[p1] != max) {
                value[p1] = max;
                size[p1] = 0;
            }
            if (value[p2] != max) {
                value[p2] = max;
                size[p2] = 0;
            }
            res += size[p1] * size[p2];
            size[p1] += size[p2];
            parent[p2] = p1;
        }
        return res + vals.length;
    }

    private int find(int[] parent, int i) {
        return parent[i] == i ? i : (parent[i] = find(parent, parent[i]));
    }
}
