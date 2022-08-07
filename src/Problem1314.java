public class Problem1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] prefix = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 && j == 0) {
                    prefix[i][j] = mat[i][j];
                } else if (i == 0) {
                    prefix[i][j] = prefix[i][j - 1] + mat[i][j];
                } else if (j == 0) {
                    prefix[i][j] = prefix[i - 1][j] + mat[i][j];
                } else {
                    prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + mat[i][j];
                }
            }
        }

        int[][] res = new int[mat.length][mat[0].length];
for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int left = Math.max(0, j - k);
                int right = Math.min(mat[0].length - 1, j + k);
                int top = Math.max(0, i - k);
                int bottom = Math.min(mat.length - 1, i + k);
                res[i][j] = prefix[bottom][right];
                if (top > 0) {
                    res[i][j] -= prefix[top - 1][right];
                }
                if (left > 0) {
                    res[i][j] -= prefix[bottom][left - 1];
                }
                if (top > 0 && left > 0) {
                    res[i][j] += prefix[top - 1][left - 1];
                }
            }
        }
        return res;
    }
}
