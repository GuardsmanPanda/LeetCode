public class Problem1770 {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[multipliers.length + 1][multipliers.length + 1];
        return maxScore(0, 0, nums, multipliers, dp);
    }

    private int maxScore(int left, int right, int[] nums, int[] mul, int[][] dp) {
        if (left + right == nums.length) {
            return 0;
        }
        if (dp[left][right] == 0) {
            int scoreLeft = nums[left] * mul[left + right] + maxScore(left + 1, right, nums, mul, dp);
            int scoreRight = nums[nums.length - 1 - right] * mul[left + right] + maxScore(left, right + 1, nums, mul, dp);
            dp[left][right] = Math.max(scoreLeft, scoreRight);
        }
        return dp[left][right];
    }
}
