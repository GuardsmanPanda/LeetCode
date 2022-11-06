package Problem1800;

import java.util.Arrays;

public class Problem1891 {
    public int maxLength(int[] ribbons, int k) {
        int low = 0, high = 100_000;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            int cuts = Arrays.stream(ribbons).map(i -> i / mid).sum();
            if (cuts >= k) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
