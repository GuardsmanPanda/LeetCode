package Problem600;

import java.util.HashSet;

public class Problem694 {
    public int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        HashSet<String> seen = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder hash = dfs(grid, i, j, 'S', visited, new StringBuilder());
                    if (seen.add(hash.toString())) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private StringBuilder dfs(int[][] grid, int i, int j, char dir, boolean[][] visited, StringBuilder hash) {
        hash.append(dir);
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return hash;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j, 'D', visited, hash);
        dfs(grid, i - 1, j, 'U', visited, hash);
        dfs(grid, i, j + 1, 'R', visited, hash);
        dfs(grid, i, j - 1, 'L', visited, hash);
        return hash;
    }
}
