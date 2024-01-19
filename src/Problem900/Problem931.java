package Problem900;

import java.util.Arrays;

public class Problem931 {
    private static final int INF = 1_000_000_000;

    public int minFallingPathSum(int[][] matrix) {
        int[] dp = new int[matrix[0].length];
        for(int[] row : matrix) {
            int prev = INF;
            for (int i = 0; i < row.length; i++) {
                int bestBefore = Math.min(prev, dp[i]);
                if (i < row.length - 1) {
                    bestBefore = Math.min(bestBefore, dp[i + 1]);
                }
                prev = dp[i];
                dp[i] = bestBefore + row[i];
            }
        }
        return Arrays.stream(dp).min().orElse(INF);
    }
}
