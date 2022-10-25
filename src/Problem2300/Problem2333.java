package Problem2300;

import java.util.Arrays;

public class Problem2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diff = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
        }
        int low = 0, high = 1_000_000_000, change = k1 + k2;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            long remove = 0;
            for (int i : diff) {
                if (i >= mid) {
                    remove += i - mid;
                }
            }
            if (remove > change) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        for (int i : diff) {
            if (i >= low) {
                change -= i - low;
            }
        }
        long res = 0;
        for (int i : diff) {
            i = Math.min(i, low);
            if (i == low && i > 0 && change --> 0) {
                i--;
            }
            res += (long) i * i;
        }
        return res;
    }
}
