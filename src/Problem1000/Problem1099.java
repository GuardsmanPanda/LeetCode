package Problem1000;

import java.util.TreeSet;

public class Problem1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int max = -1;
        for (int num : nums) {
            Integer floor = set.floor(k - num - 1);
            if (floor != null) {
                max = Math.max(max, floor + num);
            }
            set.add(num);
        }
        return max;
    }
}
