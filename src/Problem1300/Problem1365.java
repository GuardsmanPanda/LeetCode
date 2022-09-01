package Problem1300;

public class Problem1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int i : nums) {
            count[i]++;
        }
        for (int i = 1; i < 101; i++) {
            count[i] += count[i-1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? 0 : count[nums[i]-1];
        }
        return nums;
    }
}
