package Problem400;

public class Problem410 {
    public int splitArray(int[] nums, int m) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (groupCount(nums, mid) <= m) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private long groupCount(int[] a, long target) {
        long cur = 0;
        int result = 1;
        for (int val : a) {
            if (val > target) {
                return Integer.MAX_VALUE;
            }
            cur += val;
            if (cur > target) {
                cur = val;
                result++;
            }
        }
        return result;
    }
}
