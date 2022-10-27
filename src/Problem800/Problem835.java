package Problem800;

public class Problem835 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[][] count = new int[2 * n + 1][2 * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    for (int i2 = 0; i2 < n; i2++) {
                        for (int j2 = 0; j2 < n; j2++) {
                            if (img2[i2][j2] == 1) {
                                count[i - i2 + n][j - j2 + n]++;
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int[] row : count) {
            for (int v : row) {
                res = Math.max(res, v);
            }
        }
        return res;
    }
}
