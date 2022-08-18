package Problem400;

import java.util.Arrays;

public class Problem494 {
    public int findTargetSumWays(int[] nums, int target) {
        int[] ways = new int[2002];
        int[] next = new int[2002];
        ways[1000] = 1;
        for (int num : nums) {
            Arrays.fill(next, 0);
            for (int i = 0; i < ways.length; i++) {
                if (i - num >= 0) {
                    next[i] += ways[i - num];
                }
                if (i + num < ways.length) {
                    next[i] += ways[i + num];
                }
            }
            int[] tmp = ways;
            ways = next;
            next = tmp;
        }
        return ways[target + 1000];
    }
}
