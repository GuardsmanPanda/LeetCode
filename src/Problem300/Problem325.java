package Problem300;

import java.util.HashMap;

public class Problem325 {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0, maxLength = 0;
        sumMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer idx = sumMap.get(sum - k);
            if (idx != null) {
                maxLength = Math.max(maxLength, i - idx);
            }
            sumMap.putIfAbsent(sum, i);
        }
        return maxLength;
    }
}
