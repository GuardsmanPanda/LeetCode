package Problem500;

import java.util.HashMap;
import java.util.Map;

public class Problem525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int sum = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            Integer prevIndex = sumMap.putIfAbsent(sum, i);
            if (prevIndex != null)
                maxLength = Math.max(maxLength, i - prevIndex);
        }
        return maxLength;
    }
}
