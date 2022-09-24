package Problem1800;

public class Problem1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int cur = 0, mask = (1 << maximumBit) - 1;
        for (int num : nums) {
            cur ^= num;
        }
        for (int i = nums.length - 1, idx = 0; i >= 0; i--, idx++) {
            res[idx] = cur ^ mask;
            cur ^= nums[i];
        }
        return res;
    }
}
