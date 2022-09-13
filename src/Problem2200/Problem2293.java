package Problem2200;

public class Problem2293 {
    public int minMaxGame(int[] nums) {
        while (nums.length > 1) {
            int[] next = new int[nums.length / 2];
            for (int i = 0; i < next.length; i++) {
                next[i] = i % 2 == 1 ? Math.max(nums[i * 2], nums[i * 2 + 1]) : Math.min(nums[i * 2], nums[i * 2 + 1]);
            }
            nums = next;
        }
        return nums[0];
    }
}
