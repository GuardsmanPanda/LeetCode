package Problem1200;

import java.util.Arrays;

public class Problem1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] index : indices) {
            for (int i = 0; i < n; i++) {
                matrix[index[0]][i]++;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][index[1]]++;
            }
        }
        return Arrays.stream(matrix)
                .mapToInt(row -> (int) Arrays.stream(row).filter(num -> num % 2 == 1).count())
                .sum();
    }
}
