package Problem;

public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        if (N1 > N2) return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = 2 * N1;
        while (lo <= hi) {
            int C1 = (lo + hi) / 2;
            int C2 = N1 + N2 - C1;

            double L1 = (C1 == 0) ? Integer.MIN_VALUE : nums1[(C1 - 1) / 2];
            double R1 = (C1 == 2 * N1) ? Integer.MAX_VALUE : nums1[C1 / 2];
            double L2 = (C2 == 0) ? Integer.MIN_VALUE : nums2[(C2 - 1) / 2];
            double R2 = (C2 == 2 * N2) ? Integer.MAX_VALUE : nums2[C2 / 2];

            if (L1 > R2) hi = C1 - 1;
            else if (L2 > R1) lo = C1 + 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }
}
