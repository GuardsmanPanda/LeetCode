package Problem2000;

import java.util.HashMap;
import java.util.Map;

public class Problem2085 {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> w1 = new HashMap<>();
        HashMap<String, Integer> w2 = new HashMap<>();
        for (String word : words1) {
            w1.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        for (String word : words2) {
            w2.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> e : w1.entrySet()) {
            if (e.getValue() == 1 && w2.getOrDefault(e.getKey(), 0) == 1) {
                res++;
            }
        }
        return res;
    }
}
