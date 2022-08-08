public class Problem1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int low  = 0, high = Math.min(n, m);
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (verifySize(prefixSum, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean verifySize(int[][] prefix, int size, int cap) {
        for (int i = size; i < prefix.length; i++) {
            for (int j = size; j < prefix[0].length; j++) {
                if (prefix[i][j] - prefix[i - size][j] - prefix[i][j - size] + prefix[i - size][j - size] <= cap) {
                    return true;
                }
            }
        }
        return false;
    }
}
