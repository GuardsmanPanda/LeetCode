package Problem2200;

import java.util.ArrayList;
import java.util.List;

public class Problem2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] f1 = new boolean[2002];
        boolean[] f2 = new boolean[2002];
        for (int num : nums1) {
            f1[num + 1000] = true;
        }
        for (int num : nums2) {
            f2[num + 1000] = true;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        for (int i : nums1) {
            if (!f2[i + 1000]) {
                f2[i + 1000] = true;
                r1.add(i);
            }
        }
        for (int i : nums2) {
            if (!f1[i + 1000]) {
                f1[i + 1000] = true;
                r2.add(i);
            }
        }
        result.add(r1);
        result.add(r2);
        return result;
    }
}
