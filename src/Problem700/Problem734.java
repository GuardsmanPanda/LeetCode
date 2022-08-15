package Problem700;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Problem734 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, HashSet<String>> pairs = new HashMap<>();
        for (List<String> pair : similarPairs) {
            pairs.computeIfAbsent(pair.get(0), k -> new HashSet<>()).add(pair.get(1));
            pairs.computeIfAbsent(pair.get(1), k -> new HashSet<>()).add(pair.get(0));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (!pairs.containsKey(sentence1[i]) || !pairs.get(sentence1[i]).contains(sentence2[i])) {
                return false;
            }
        }
        return true;
    }
}
