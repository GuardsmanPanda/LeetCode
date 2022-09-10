package Problem1800;

public class Problem1863 {
    public int subsetXORSum(int[] nums) {
        return getSum(nums, 0, 0);
    }

    private int getSum(int[] nums, int index, int xor) {
        if (index == nums.length) {
            return xor;
        }
        return getSum(nums, index + 1, xor ^ nums[index]) + getSum(nums, index + 1, xor);
    }
}
