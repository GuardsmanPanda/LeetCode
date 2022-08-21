package Problem2200;

import java.util.*;

public class Problem2203 {
    private static final long INF = 100000000000L;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> graphRev = new ArrayList<>();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graphRev.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graphRev.get(edge[1]).add(new int[] {edge[0], edge[2]});
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
        long[] distSrc = new long[n];
        long[] dist1 = new long[n];
        long[] dist2 = new long[n];
        Arrays.fill(distSrc, INF);
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        dijkstra(graphRev, dest, distSrc);
        dijkstra(graph, src1, dist1);
        dijkstra(graph, src2, dist2);
        System.out.println(Arrays.toString(distSrc));
        System.out.println(Arrays.toString(dist1));
        System.out.println(Arrays.toString(dist2));
        long ans = INF;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, distSrc[i] + dist1[i] + dist2[i]);
        }
        return ans == INF ? -1 : ans;
    }

    private void dijkstra(List<List<int[]>> graph, int src, long[] dist) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[] {src, 0});
        boolean[] visited = new boolean[graph.size()];
        dist[src] = 0;
        while (pq.size() > 0) {
            long[] cur = pq.remove();
            int node = (int) cur[0];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            for (int[] adj : graph.get(node)) {
                long cost = adj[1] + cur[1];
                if (cost < dist[adj[0]]) {
                    dist[adj[0]] = cost;
                    pq.add(new long[] {adj[0], cost});
                }
            }
        }
    }
}
