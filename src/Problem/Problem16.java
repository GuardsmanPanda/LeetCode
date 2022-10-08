package Problem;

import java.util.Arrays;

public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        int closest = 10_000_000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1, high = nums.length - 1, val = nums[i];
            while (low < high) {
                int cur = val + nums[low] + nums[high];
                if (Math.abs(target - cur) < Math.abs(target - closest)) {
                    closest = cur;
                }
                if (cur > target) {
                    high--;
                } else low++;
            }
        }
        return closest;
    }
}
