package Problem1400;

import java.util.Arrays;

public class Problem1498 {
    // 1,2,3 -> [1] [2] [3], [1,2] [1,3] [2,3], [1,2,3]
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = (pow[i - 1] * 2) % 1000000007;
        }
        int left = 0, right = nums.length - 1;
        int res = 0;
        while (left <= right) {
            while (right >= 0 && nums[right] + nums[left] > target) {
                right--;
            }
            if (right < left) {
                break;
            }
            res += pow[right - left];
            res %= 1000000007;
            left++;
        }
        return res;
    }
}
