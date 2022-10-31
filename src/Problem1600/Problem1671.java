package Problem1600;

import java.util.ArrayList;

public class Problem1671 {
    public int minimumMountainRemovals(int[] nums) {
        ArrayList<Integer> lis = new ArrayList<>();
        int[] lisLeft = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i], idx = getLargerIdx(lis, n);
            if (idx == lis.size()) {
                lis.add(n);
            } else {
                lis.set(idx, n);
            }
            lisLeft[i] = lis.size();
            System.out.println("i = " + i + ", lisLeft = " + lisLeft[i]);
        }
        int res = Integer.MAX_VALUE;
        lis.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i], idx = getLargerIdx(lis, n);
            if (idx == lis.size()) {
                lis.add(n);
            } else {
                lis.set(idx, n);
            }
            if (lisLeft[i] > 1 && lis.size() > 1) {
                res = Math.min(res, nums.length - lisLeft[i] - lis.size() + 1);
            }
        }
        return res;
    }

    private int getLargerIdx(ArrayList<Integer> lis, int n) {
        int lo = 0, hi = lis.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (lis.get(mid) < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
// [100,92,89,77,74,66,64,66,64]
//    1  1  1  1  1  1  1  2  2
//    7  6  5  4  3  2  2  2  1
