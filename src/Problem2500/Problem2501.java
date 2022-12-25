package Problem2500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2501 {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        Arrays.sort(nums);
        for (int num : nums) {
            int len = map.getOrDefault(num, 0) + 1;
            map.compute(num * num, (k, v) -> v == null ? len : Math.max(v, len));
        }
        int res = map.values().stream().mapToInt(i -> i).max().orElse(0);
        return res > 1 ? res : -1;
    }
}
