package Problem2200;

public class Problem2219 {
    public long maximumSumScore(int[] nums) {
        long max = Integer.MIN_VALUE, min = 0, sum = 0;
        for (int num : nums) {
            min = Math.min(min, sum);
            sum += num;
            max = Math.max(max, sum);
        }
        return Math.max(max, sum - min);
    }
}
