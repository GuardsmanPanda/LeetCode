package Problem800;

import java.util.*;

public class Problem815 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        Map<Integer, List<Integer>> stopMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int k : route) {
                stopMap.computeIfAbsent(k, key -> new ArrayList<>()).add(i);
            }
        }
        if (!stopMap.containsKey(T)) {
            return -1;
        }
        int[] targeted = new int[routes.length];
        int[] visited = new int[routes.length];
        for (Integer integer : stopMap.get(T)) {
            targeted[integer] = 1;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (Integer integer : stopMap.get(S)) {
            queue.addFirst(integer);
            if (targeted[integer] == 1) {
                return 1;
            }
            visited[integer] = 1;
        }
        while (queue.size() > 0) {
            Integer cur = queue.removeLast();
            for (int stop : routes[cur]) {
                for (Integer adj : stopMap.get(stop)) {
                    if (visited[adj] == 0) {
                        visited[adj] = visited[cur] + 1;
                        if (targeted[adj] == 1) {
                            return visited[cur] + targeted[adj];
                        }
                        queue.addFirst(adj);
                    }
                }
            }
        }
        return -1;
    }
}
