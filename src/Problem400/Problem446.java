package Problem400;

import java.util.*;

public class Problem446 {
    public int numberOfArithmeticSlices(int[] nums) {
        List<Map<Long, Integer>> dp = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp.add(new HashMap<>());
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[i] - nums[j];
                int count = dp.get(j).getOrDefault(diff, 0);
                result += count;
                dp.get(i).put(diff, dp.get(i).getOrDefault(diff, 0) + count + 1);
            }
        }
        return result;
    }
}
