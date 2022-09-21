package Problem1800;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem1874 {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return IntStream.range(0, nums1.length)
                .map(i -> nums1[i] * nums2[nums2.length - i - 1])
                .sum();
    }
}
