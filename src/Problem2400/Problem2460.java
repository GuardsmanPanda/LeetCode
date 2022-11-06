package Problem2400;

public class Problem2460 {
    public int[] applyOperations(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
        }
        int idx = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[idx++] = n;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
        return nums;
    }
}
