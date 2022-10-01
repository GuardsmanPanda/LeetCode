package Problem2400;

public class Problem2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0;
        if (nums1.length % 2 == 1) {
            for (int i : nums2) {
                res ^= i;
            }
        }
        if (nums2.length % 2 == 1) {
            for (int i : nums1) {
                res ^= i;
            }
        }
        return res;
    }
}
