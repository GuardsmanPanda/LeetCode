package Problem300;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) return new int[0];
        Map<Integer, Integer> intFrequency = new HashMap<>();
        for (int num : nums) intFrequency.put(num, intFrequency.getOrDefault(num, 0) + 1);

        return intFrequency.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
