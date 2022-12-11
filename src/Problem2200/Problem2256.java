package Problem2200;

import java.util.Arrays;

public class Problem2256 {
    public int minimumAverageDifference(int[] nums) {
        long sum = Arrays.stream(nums).mapToLong(i -> i).sum(), avg = Long.MAX_VALUE;
        long currentSum = 0;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            sum -= nums[i];
            long avg1 = currentSum / (i + 1);
            long avg2 = i == nums.length - 1 ? 0 : sum / (nums.length - i - 1);
            long curAvg = Math.abs(avg1 - avg2);
            if (curAvg < avg) {
                avg = curAvg;
                idx = i;
            }
        }
        return idx;
    }
}
