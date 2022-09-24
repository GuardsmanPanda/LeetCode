package Problem1500;

import java.util.HashMap;
import java.util.Map;

public class Problem1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        return getCount(nums1, nums2) + getCount(nums2, nums1);
    }

    private int getCount(int[] a, int[] b) {
        Map<Long, Integer> counter = new HashMap<>();
        for (long i : a) {
            counter.compute(i * i, (k, v) -> v == null ? 1 : v + 1);
        }
        int res = 0;
        for (int i = 0; i < b.length; i++) {
            long x = b[i];
            for (int j = i + 1; j < b.length; j++) {
                res += counter.getOrDefault(x * b[j], 0);
            }
        }
        return res;
    }
}
