package Problem1200;

public class Problem1277 {
    public int countSquares(int[][] matrix) {
        int[][] cnt = new int[matrix.length + 1][matrix[0].length + 1];
        int res = 0;
        for (int i = 1; i < cnt.length; i++) {
            for (int j = 1; j < cnt[0].length; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    cnt[i][j] = Math.min(cnt[i - 1][j - 1], Math.min(cnt[i - 1][j], cnt[i][j - 1])) + 1;
                    res += cnt[i][j];
                }
            }
        }
        return res;
    }
}
