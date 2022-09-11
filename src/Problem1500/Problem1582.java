package Problem1500;

import java.util.stream.IntStream;

public class Problem1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }
        return IntStream.range(0, m).map(i -> IntStream.range(0, n)
                        .map(j -> mat[i][j] == 1 && row[i] == 1 && col[j] == 1 ? 1 : 0)
                        .sum()).sum();
    }
}
