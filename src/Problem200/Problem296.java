package Problem200;

import java.util.Arrays;

public class Problem296 {
    public int minTotalDistance(int[][] grid) {
        int[] col = new int[grid[0].length];
        int[] row = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                col[j] += grid[i][j];
                row[i] += grid[i][j];
            }
        }
        int[] rowCost = new int[grid.length];
        for (int i = 1, rowTotal = row[0]; i < rowCost.length; i++) {
            rowCost[i] = rowCost[i - 1] + rowTotal;
            rowTotal += row[i];
        }
        int rowMin = rowCost[rowCost.length - 1];
        for (int i = row.length - 2, count = row[row.length - 1], total = 0; i >= 0; i--) {
            total += count;
            count += row[i];
            rowMin = Math.min(rowCost[i] + total, rowMin);
        }

        int[] colCost = new int[grid[0].length];
        for (int i = 1, colTotal = col[0]; i < colCost.length; i++) {
            colCost[i] = colCost[i - 1] + colTotal;
            colTotal += col[i];
        }
        int colMin = colCost[colCost.length - 1];
        for (int i = col.length - 2, count = col[col.length - 1], total = 0; i >= 0; i--) {
            total += count;
            count += col[i];
            colMin = Math.min(colCost[i] + total, colMin);
        }
        return rowMin + colMin;
    }
}
