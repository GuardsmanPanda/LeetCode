package Problem300;

public class Problem329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] pathLength = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pathLength[i][j] == 0) {
                    longest = Math.max(longest, getPathLength(i, j, matrix, pathLength));
                }
            }
        }
        return longest;
    }
    private final int[][] offsets = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int getPathLength(int x, int y, int[][] grid, int[][] length) {
        int current = 0;
        for (int[] delta : offsets) {
            int xx = x+delta[0], yy = y+delta[1];
            if (xx < 0 || yy < 0 || xx >= grid.length || yy >= grid[0].length || grid[xx][yy] <= grid[x][y])
                continue;
            if (length[xx][yy] != 0) current = Math.max(current, length[xx][yy]);
            else current = Math.max(current, getPathLength(xx, yy, grid, length));
        }
        length[x][y] = current+1;
        return current+1;
    }
}
