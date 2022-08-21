package Problem1400;

import java.util.*;

public class Problem1494 {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n + 1];
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            inDegree[relation[1]]++;
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        for (int i = 1; i <= n; i++) {
            if (dist[i] == -1) {
                getMaxDist(i, graph, dist);
            }
        }
        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(inDegree));
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(new int[] {i, dist[i]});
            }
        }
        int steps = 0;
        while (queue.size() > 0) {
            List<Integer> toProcess = new ArrayList<>();
            for (int i = 0; i < k && queue.size() > 0; i++) {
                toProcess.add(queue.remove()[0]);
            }
            System.out.println("new round");
            System.out.println(toProcess);
            for (Integer node : toProcess) {
                graph.get(node).forEach(next -> {
                    if (--inDegree[next] == 0) {
                        queue.add(new int[] {next, dist[next]});
                    }
                });
            }
            steps++;
        }
        return steps;
    }

    private int getMaxDist(int node, List<List<Integer>> graph, int[] dist) {
        if (dist[node] == -1) {
            int max = 0;
            for (int next : graph.get(node)) {
                max = Math.max(max, getMaxDist(next, graph, dist));
            }
            dist[node] = max + 1;
        }
        return dist[node];
    }
}
