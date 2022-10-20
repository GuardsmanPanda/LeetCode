package Problem1400;

public class Problem1493 {
    public int longestSubarray(int[] nums) {
        int max = 0, cur = 0, last = 0;
        for (int n : nums) {
            if (n == 1) {
                cur++;
            } else {
                last = cur;
                cur = 0;
            }
            max = Math.max(max, last + cur);
        }
        return max == nums.length ? max - 1 : max;
    }
}
