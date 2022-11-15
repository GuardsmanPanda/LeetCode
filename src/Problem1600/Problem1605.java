package Problem1600;

public class Problem1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                int val = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= val;
                colSum[j] -= val;
                res[i][j] = val;
            }
        }
        return res;
    }
}
