package Problem2200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2273 {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        String last = "";
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            if (!last.equals(new String(chars))) {
                res.add(word);
                last = new String(chars);
            }
        }
        return res;
    }
}
