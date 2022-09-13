package Problem1700;

public class Problem1752 {
    public boolean check(int[] nums) {
        int error = nums[0] < nums[nums.length - 1] ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (++error == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
