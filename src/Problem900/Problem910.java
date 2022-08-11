package Problem900;

import java.util.Arrays;

public class Problem910 {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int diff = nums[nums.length - 1] - nums[0];
        int max = nums[nums.length - 1] - k, min = nums[0] + k;
        for (int i = 1 ; i < nums.length; i++) {
            int n1 = nums[i - 1] + k;
            int n2 = nums[i] - k;
            int min2 = Math.min(min, n2);
            int max2 = Math.max(max, n1);
            diff = Math.min(diff, max2 - min2);
        }
        return diff;
    }
}
