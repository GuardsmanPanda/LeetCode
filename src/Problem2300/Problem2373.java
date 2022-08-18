package Problem2300;

public class Problem2373 {
    public int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        max = Math.max(max, grid[i + k - 1][j + l - 1]);
                    }
                }
                res[i - 1][j - 1] = max;
            }
        }
        return res;
    }
}
