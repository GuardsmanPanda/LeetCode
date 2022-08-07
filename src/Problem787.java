import java.util.*;

public class Problem787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] flight : flights) graph.get(flight[0]).add(new int[] {flight[1], flight[2]});

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[] {src, 0, 0});
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        while (queue.size() > 0) {
            int[] node = queue.remove();
            visited[node[0]] = node[2];
            if (node[0] == dst) return node[1];
            if (node[2] == K+1) continue;
            for (int[] flight : graph.get(node[0])) {
                if (visited[flight[0]] > node[2]) {
                    queue.add(new int[] {flight[0], node[1] + flight[1], node[2] + 1});
                }
            }
        }
        return -1;
    }
}
