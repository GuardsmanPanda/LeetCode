package Problem1800;

public class Problem1827 {
    public int minOperations(int[] nums) {
        int ans = 0, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= last) {
                ans += last - nums[i] + 1;
                last++;
            } else {
                last = nums[i];
            }
        }
        return ans;
    }
}
