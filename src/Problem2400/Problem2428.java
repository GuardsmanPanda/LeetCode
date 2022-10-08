package Problem2400;

public class Problem2428 {
    public int maxSum(int[][] grid) {
        int max = 0;
        for (int i = 2; i < grid.length; i++) {
            for (int j = 2; j < grid[0].length; j++) {
                int cur = grid[i][j] + grid[i][j - 1] + grid[i][j - 2];
                cur += grid[i - 1][j - 1];
                cur += grid[i - 2][j] + grid[i - 2][j - 1] + grid[i - 2][j - 2];
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
