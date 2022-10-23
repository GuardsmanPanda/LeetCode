package Problem2100;

public class Problem2104 {
    public long subArrayRanges(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += max - min;
            }
        }
        return result;
    }
}
