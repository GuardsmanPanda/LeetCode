package Problem1700;

import java.util.Arrays;

public class Problem1708 {
    public int[] largestSubarray(int[] nums, int k) {
        int idx = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            boolean bigger = false;
            for (int j = 0; j < k; j++) {
                if (nums[i + j] != nums[idx + j]) {
                    bigger = nums[i + j] > nums[idx + j];
                    break;
                }
            }
            if (bigger) {
                idx = i;
            }
        }
        return Arrays.copyOfRange(nums, idx, idx + k);
    }
}
