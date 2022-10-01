package Problem2400;

public class Problem2426 {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int[] fenwick = new int[60010];
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int di = nums1[i] - nums2[i] + 30005;
            int idx = di + diff;
            while (idx > 0) {
                res += fenwick[idx];
                idx -= idx & (-idx);
            }
            while (di < fenwick.length) {
                fenwick[di]++;
                di += di & (-di);
            }
        }
        return res;
    }
}
