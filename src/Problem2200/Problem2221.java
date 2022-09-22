package Problem2200;

public class Problem2221 {
    public int triangularSum(int[] nums) {
        int len = nums.length;
        while (len > 1) {
            for (int i = 0; i < len - 1; i++) {
                nums[i] += nums[i + 1];
                nums[i] %= 10;
            }
            len--;
        }
        return nums[0];
    }
}
