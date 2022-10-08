package Problem2300;

import java.util.*;

public class Problem2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> seen = new HashSet<>();
        Arrays.stream(restricted).forEach(seen::add);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            if (!seen.contains(edge[0]) && !seen.contains(edge[1])) {
                graph.get(edge[1]).add(edge[0]);
                graph.get(edge[0]).add(edge[1]);
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        int count = 0;
        vis[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            count++;
            for (Integer adj : graph.get(queue.remove())) {
                if (!vis[adj]) {
                    vis[adj] = true;
                    queue.add(adj);
                }
            }
        }
        return count;
    }
}
