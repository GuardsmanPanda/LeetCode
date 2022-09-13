package Problem2000;

public class Problem2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        if (original.length != m * n) {
            return new int[0][0];
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(original, i * n, res[i], 0, n);
        }
        return res;
    }
}
