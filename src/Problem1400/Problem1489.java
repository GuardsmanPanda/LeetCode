package Problem1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] edgesWithIndex = new int[edges.length + 1][];
        for (int i = 0; i < edges.length; i++) {
            edgesWithIndex[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        edgesWithIndex[edges.length] = new int[]{0, 0, Integer.MAX_VALUE, -1};
        Arrays.sort(edgesWithIndex, Comparator.comparingInt(a -> a[2]));
        int cost = mstCost(edgesWithIndex, n);

        List<Integer> critical = new ArrayList<>(), pseudo = new ArrayList<>();
        for (int[] edge : edgesWithIndex) {
            if (edge[3] == -1) {
                continue;
            }
            boolean[] res = checkEdge(edgesWithIndex, edge, n, cost);
            if (res[0]) {
                critical.add(edge[3]);
            } else if (res[1]) {
                pseudo.add(edge[3]);
            }
        }
        return List.of(critical, pseudo);
    }

    private int mstCost(int[][] edges, int n) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int cost = 0;
        for (int[] edge : edges) {
            int x = find(parent, edge[0]), y = find(parent, edge[1]);
            if (x != y) {
                parent[x] = y;
                cost += edge[2];
            }
        }
        return cost;
    }


    private boolean[] checkEdge(int[][] edges, int[] edge, int size, int cost) {
        int[] parent = new int[size];
        boolean pseudoCritical = false, pseudoCriticalFail = false;
        int treeCost = 0;
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        for (int[] e : edges) {
            if (e[3] == edge[3]) {
                continue;
            }
            int p1 = find(parent, e[0]), p2 = find(parent, e[1]);
            if (p1 != p2) {
                parent[p1] = p2;
                treeCost += e[2];
            }
            int p3 = find(parent, edge[0]), p4 = find(parent, edge[1]);
            if (p3 == p4 && e[2] < edge[2]) {
                pseudoCriticalFail = true;
            }
            if (p3 == p4 && e[2] == edge[2]) {
                pseudoCritical = true;
            }
        }
        return new boolean[]{treeCost != cost, pseudoCritical && !pseudoCriticalFail};
    }

    private int find(int[] parent, int i) {
        return parent[i] == i ? i : (parent[i] = find(parent, parent[i]));
    }
}
