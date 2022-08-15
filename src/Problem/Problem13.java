package Problem;

import java.util.Map;

public class Problem13 {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int res = 0;
        int idx = s.length();
        while (idx-- > 0) {
            int val = romanMap.get(s.charAt(idx));
            if (idx > 0 && romanMap.get(s.charAt(idx - 1)) < val) {
                res -= romanMap.get(s.charAt(idx - 1));
                idx--;
            }
            res += val;
        }
        return res;
    }
}
