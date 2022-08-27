package Problem2200;

public class Problem2210 {
    public int countHillValley(int[] nums) {
        int idx = 1;
        while (idx < nums.length && nums[idx] == nums[idx - 1]) {
            idx++;
        }
        if (idx == nums.length) {
            return 0;
        }
        boolean increasing = nums[idx] > nums[idx - 1];
        int shifts = 0;
        while (++idx < nums.length) {
            if (increasing && nums[idx] < nums[idx - 1]) {
                increasing = false;
                shifts++;
            } else if (!increasing && nums[idx] > nums[idx - 1]) {
                increasing = true;
                shifts++;
            }
        }
        return shifts;
    }
}
