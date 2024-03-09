package Problem2500;

public class Problem2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            int v1 = nums1[idx1], v2 = nums2[idx2];
            if (v1 == v2) {
                return v1;
            }
            if (v1 < v2) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return -1;
    }
}
