package Problem500;

public class Problem547 {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int components = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                markComponent(i, M, visited);
                components++;
            }
        }
        return components;
    }

    private void markComponent(int node, int[][] M, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < M.length; i++) {
            if (M[node][i] == 1 && !visited[i])
                markComponent(i, M, visited);
        }
    }
}
