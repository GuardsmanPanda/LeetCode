import java.util.Arrays;

public class Problem123 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        System.out.println(Arrays.toString(dp));
        int max = prices[prices.length - 1];
        int res = dp[prices.length - 1];
        for (int i = prices.length - 2; i >= 1; i--) {
            max = Math.max(max, prices[i]);
            dp[i] = Math.max(dp[i], max - prices[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
