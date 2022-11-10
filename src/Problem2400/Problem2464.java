package Problem2400;

import java.util.Arrays;

public class Problem2464 {
    public int validSubarraySplit(int[] nums) {
        int[] minSplits = new int[nums.length + 1];
        Arrays.fill(minSplits, Integer.MAX_VALUE);
        minSplits[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (minSplits[i] == Integer.MAX_VALUE) {
                continue;
            }
            int n = nums[i];
            for (int j = i; j < nums.length; j++) {
                int g = gcd(n, nums[j]);
                if (g > 1) {
                    minSplits[j + 1] = Math.min(minSplits[j + 1], minSplits[i] + 1);
                }
            }
        }
        return minSplits[nums.length] == Integer.MAX_VALUE ? -1 : minSplits[nums.length];
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
