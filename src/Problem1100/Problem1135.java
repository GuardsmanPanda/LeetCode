package Problem1100;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1135 {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int cost = 0;
        for (int[] connection : connections) {
            int x = find(parent, connection[0] - 1);
            int y = find(parent, connection[1] - 1);
            if (x != y) {
                parent[x] = y;
                cost += connection[2];
                n--;
            }
        }
        return n == 1 ? cost : -1;
    }

    private int find(int[] parent, int x) {
        return parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }
}
