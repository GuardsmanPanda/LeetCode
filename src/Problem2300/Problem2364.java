package Problem2300;

import java.util.HashMap;

public class Problem2364 {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        long goodPairs = 0, total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += i;
            int cur = nums[i] - i;
            int res = countMap.compute(cur, (k, v) -> v == null ? 1 : v + 1);
            goodPairs += res - 1;
        }
        return total - goodPairs;
    }
}
