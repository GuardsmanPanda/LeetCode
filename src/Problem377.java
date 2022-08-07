public class Problem377 {
    public int combinationSum4(int[] nums, int target) {
        int[] combinations = new int[target + 1];
        combinations[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    combinations[i] += combinations[i - num];
                }
            }
        }
        return combinations[target];
    }
}
