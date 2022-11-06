package Problem2400;

public class Problem2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] count = new int[100_001];
        int diff = 0;
        long sum = 0, max = 0;
        for (int i = 0; i < k - 1; i++) {
            if (count[nums[i]]++ == 1) {
                diff++;
            }
            sum += nums[i];
        }
        for (int i = k - 1; i < nums.length; i++) {
            if (count[nums[i]]++ == 1) {
                diff++;
            }
            sum += nums[i];
            if (diff == 0) {
                max = Math.max(max, sum);
            }
            sum -= nums[i - k + 1];
            if (--count[nums[i - k + 1]] == 1) {
                diff--;
            }
        }
        return max;
    }
}
