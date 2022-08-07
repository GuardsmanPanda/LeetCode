public class Problem1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; i++) {
            while (j < nums2.length && nums1[i] <= nums2[j]) {
                max = Math.max(max, j - i);
                j++;
            }
        }
        return max;
    }
}
