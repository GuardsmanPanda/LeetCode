package Problem2100;

import java.util.HashMap;
import java.util.Map;

public class Problem2131 {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int ans = 0;
        for (String word : words) {
            Integer count = map.get(word);
            String rev = new StringBuilder(word).reverse().toString();
            Integer reverse = map.getOrDefault(rev,0);
            int min = Math.min(count, reverse);
            boolean duplicate = word.equals(rev);
            if (min == 0 || (duplicate && min == 1)) {
                continue;
            }
            if (duplicate) {
                min = min / 2;
                map.put(word, count - min*2);
            } else {
                map.put(word, count - min);
                map.put(rev, reverse - min);
            }
            ans += min * 4;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0 && entry.getKey().charAt(0) == entry.getKey().charAt(1)) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
}
