package Problem2100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2150 {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.stream(nums).forEach(i -> count.compute(i, (k, v) -> v == null ? 1 : v + 1));
        return Arrays.stream(nums)
                .filter(i -> count.get(i) == 1 && count.get(i + 1) == null && count.get(i - 1) == null)
                .boxed().toList();
    }
}
