package Problem2000;

import java.util.HashMap;
import java.util.Map;

public class Problem2053 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String s : arr) {
            count.compute(s, (key, val) -> val == null ? 1 : val + 1);
        }
        for (String s : arr) {
            if (count.get(s) == 1) {
                if (--k == 0) {
                    return s;
                }
            }
        }
        return "";
    }
}
