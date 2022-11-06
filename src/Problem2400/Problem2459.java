package Problem2400;

public class Problem2459 {
    public int sortArray(int[] nums) {
        return Math.min(fixCost(nums, 0), fixCost(nums, -1));
    }

    private int fixCost(int[] nums, int offset) {
        boolean[] fixed = new boolean[nums.length];
        int cost = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean found0 = false;
            int size = 0, idx = i;
            while (!fixed[idx]) {
                found0 |= nums[idx] == 0;
                fixed[idx] = true;
                size++;
                if (nums[idx] == 0) {
                    idx = offset == 0 ? 0 : nums.length - 1;
                } else {
                    idx = nums[idx] + offset;
                }
            }
            if (size > 0) {
                cost += found0 ? size - 1: size + 1;
            }
        }
        return cost;
    }
}
