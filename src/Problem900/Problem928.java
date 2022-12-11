package Problem900;

import java.util.Arrays;

public class Problem928 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        int result = -1, size = Integer.MAX_VALUE;
        for (int skip : initial) {
            int curSize = getSpreadSize(graph, skip, initial);
            if (curSize < size) {
                size = curSize;
                result = skip;
            }
        }
        return result;
    }

    private int getSpreadSize(int[][] graph, int skip, int[] initial) {
        boolean[] visited = new boolean[graph.length];
        visited[skip] = true;
        return Arrays.stream(initial).map(i -> dfs(graph, i, visited)).sum();
    }

    private int dfs(int[][] graph, int idx, boolean[] visited) {
        if (visited[idx]) {
            return 0;
        }
        visited[idx] = true;
        int size = 1;
        for (int i = 0; i < graph.length; i++) {
            if (graph[idx][i] == 1) {
                size += dfs(graph, i, visited);
            }
        }
        return size;
    }
}
