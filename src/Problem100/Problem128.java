package Problem100;

import java.util.HashMap;
import java.util.Map;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> boundryMap = new HashMap<>(nums.length*3);
        int maxLength = 0;
        for (int num : nums) {
            if (boundryMap.containsKey(num)) continue;
            int right = boundryMap.getOrDefault(num+1, 0);
            int left = boundryMap.getOrDefault(num-1, 0);
            int length = left+right+1;
            maxLength = Math.max(maxLength, length);
            if (right > 0 && left > 0) boundryMap.put(num, -1);
            boundryMap.put(num-left, length);
            boundryMap.put(num+right, length);
        }
        return maxLength;
    }
}
