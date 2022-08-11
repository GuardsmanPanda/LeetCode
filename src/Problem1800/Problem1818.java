package Problem1800;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Problem1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> n1 = new TreeSet<>();
        for (int n : nums1) {
            n1.add(n);
        }
        long diffSum = 0;
        long bestFix = 0;
        for (int i = 0; i < nums2.length; i++) {
            long diff = Math.abs(nums1[i] - nums2[i]);
            diffSum += diff;
            Integer a = n1.floor(nums2[i]);
            Integer b = n1.ceiling(nums2[i]);
            if (a != null) {
                bestFix = Math.max(bestFix, diff - nums2[i] + a);
            }
            if (b != null) {
                bestFix = Math.max(bestFix, diff - b + nums2[i]);
            }
            System.out.println("i: " + i + " diff: " + diff + " bestFix: " + bestFix);
        }
        return (int)((diffSum - bestFix) % 1000000007);
    }
}
