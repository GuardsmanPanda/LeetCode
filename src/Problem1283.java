public class Problem1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 2_000_000;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (test(nums, mid, threshold)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean test(int[] a, int div, int threshold) {
        int sum = 0;
        for (int j : a) {
            sum += (j + div - 1) / div;
        }
        return sum <= threshold;
    }
}
