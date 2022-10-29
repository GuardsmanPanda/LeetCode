package Problem2200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(tasks).forEach(i -> map.compute(i, (k, v) -> v == null ? 1 : v + 1));
        int res = 0;
        for (var i : map.values()) {
            if (i == 1) {
                return -1;
            }
            res += (i + 2) / 3;
        }
        return res;
    }
}
