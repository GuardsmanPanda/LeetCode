package Problem2000;

public class Problem2044 {
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target |= num;
        }
        return getCount(nums, 0, 0, target);
    }

    private int getCount(int[] nums, int idx, int cur, int target) {
        if (idx == nums.length) {
            return cur == target ? 1 : 0;
        }
        return getCount(nums, idx + 1, cur | nums[idx], target) + getCount(nums, idx + 1, cur, target);
    }
}
