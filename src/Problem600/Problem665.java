package Problem600;

public class Problem665 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        boolean seenError = false;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < last) {
                if (seenError) {
                    return false;
                }
                seenError = true;
                if (i > 1 && nums[i] < nums[i - 2]) {
                    continue;
                }
            }
            last = nums[i];
        }
        return true;
    }
}
