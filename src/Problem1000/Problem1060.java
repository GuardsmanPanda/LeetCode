package Problem1000;

public class Problem1060 {
    public int missingElement(int[] nums, int k) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int missing = nums[mid] - nums[0] - mid;
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[0] + low + k - 1;
    }
}
