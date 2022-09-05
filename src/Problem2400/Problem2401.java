package Problem2400;

public class Problem2401 {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, res = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            while ((cur & nums[i]) != 0) {
                cur ^= nums[left++];
            }
            cur |= nums[i];
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
