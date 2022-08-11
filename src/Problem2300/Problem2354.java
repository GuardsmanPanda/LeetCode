package Problem2300;

import java.util.HashSet;

public class Problem2354 {
    public long countExcellentPairs(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();
        int[] count = new int[31];
        long res = 0;
        for (int num : nums) {
            if (!seen.add(num)) {
                continue;
            }
            int bitCount = Integer.bitCount(num);
            if (bitCount * 2 >= k) {
                res++;
            }
            int target = Math.max(k - bitCount, 0);
            if (target < 31) {
                res += count[target] * 2L;
            }
            while (bitCount >= 0) {
                count[bitCount--]++;
            }
        }
        return res;
    }
}
