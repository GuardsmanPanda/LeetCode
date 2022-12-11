package Problem2400;

public class Problem2495 {
    public long evenProduct(int[] nums) {
        int lastEvent = -1;
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            lastEvent = nums[i] % 2 == 0 ? i : lastEvent;
            result += lastEvent + 1;
        }
        return result;
    }
}
