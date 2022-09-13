package Problem2400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.stream(nums).filter(i -> i % 2 == 0).forEach(i -> count.compute(i, (k, v) -> v == null ? 1 : v + 1));
        return count.entrySet().stream()
                .min((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey() - b.getKey() : b.getValue() - a.getValue())
                .map(Map.Entry::getKey).orElse(-1);
    }
}
