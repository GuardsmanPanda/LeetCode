package Problem1900;

public class Problem1909 {
    public boolean canBeIncreasing(int[] nums) {
        boolean flag = false;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= last) {
                if (!(flag = !flag)) {
                    return false;
                }
                if (i == nums.length - 1 || i < nums.length - 1 && nums[i + 1] > last) {
                    continue;
                }
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    return false;
                }
            }
            last = nums[i];
        }
        return true;
    }
}
