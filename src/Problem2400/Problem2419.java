package Problem2400;

public class Problem2419 {
    public int longestSubarray(int[] nums) {
        int maxVal = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n < maxVal) {
                continue;
            }
            if (n > maxVal) {
                maxVal = n;
                res = 0;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] == n) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j - 1;
        }
        return res;
    }
}
