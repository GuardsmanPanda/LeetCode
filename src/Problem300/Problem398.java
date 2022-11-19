package Problem300;

import java.util.*;

public class Problem398 {
    class Solution {
        private final Random random = new Random(766);
        private final Map<Integer, List<Integer>> map = new HashMap<>();
        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int pick(int target) {
            return map.get(target).get(random.nextInt(map.get(target).size()));
        }
    }
}
