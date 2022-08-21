package Problem300;

import java.util.Arrays;

public class Problem361 {
    public int maxKilledEnemies(char[][] grid) {
        int[][] rowCount = new int[grid.length + 1][grid[0].length + 1];
        int[][] colCount = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                rowCount[i + 1][j + 1] = rowCount[i + 1][j];
                colCount[i + 1][j + 1] = colCount[i][j + 1];
                if (grid[i][j] == 'E') {
                    rowCount[i + 1][j + 1]++;
                    colCount[i + 1][j + 1]++;
                }
            }
        }
        int[][] rewRowCount = new int[grid.length + 1][grid[0].length + 1];
        int[][] revColCount = new int[grid.length + 1][grid[0].length + 1];
        int max = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                rewRowCount[i][j] = rewRowCount[i + 1][j];
                revColCount[i][j] = revColCount[i][j + 1];
                if (grid[i][j] == 'E') {
                    rewRowCount[i][j]++;
                    revColCount[i][j]++;
                } else {
                    max = Math.max(max, rowCount[i + 1][j + 1] + colCount[i + 1][j + 1] + rewRowCount[i][j] + revColCount[i][j]);
                }
            }
        }
        return max;
    }
}
