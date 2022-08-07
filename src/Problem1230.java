public class Problem1230 {
    public double probabilityOfHeads(double[] prob, int target) {
        double[] dp = new double[target + 2];
        dp[0] = 1;
        for (double p : prob) {
            for (int i = target; i >= 0; i--) {
                double head = p * dp[i];
                dp[i + 1] += head;
                dp[i] -= head;
            }
        }
        return dp[target];
    }
}
