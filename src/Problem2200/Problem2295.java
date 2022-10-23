package Problem2200;

public class Problem2295 {
    private static int[] mapping = new int[1_000_001];

    public int[] arrayChange(int[] nums, int[][] operations) {
        for (int i = 0; i < nums.length; i++) {
            mapping[nums[i]] = i;
        }
        for (int[] op : operations) {
            int index = mapping[op[0]];
            nums[index] = op[1];
            mapping[op[1]] = index;
        }
        return nums;
    }
}
