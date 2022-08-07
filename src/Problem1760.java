public class Problem1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        long low = 1, high = Integer.MAX_VALUE;
        while (low < high) {
            long mid = (low + high) / 2;
            if (canDo(nums, mid, maxOperations)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    private boolean canDo(int[] nums, long target, long maxOperations) {
        long sum = 0;
        for (int num : nums) {
            sum += (num - 1) / target;
        }
        return sum <= maxOperations;
    }
}
