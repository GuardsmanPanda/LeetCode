package Problem2400;

import java.util.Arrays;

public class Problem2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j] * 2 - 1;
            }
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = sum;
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            int sum = 0;
            for (int[] row : grid) {
                sum += row[j] * 2 - 1;
            }
            for (int i = 0; i < grid.length; i++) {
                result[i][j] += sum;
            }
        }
        return result;
    }
}
