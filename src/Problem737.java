import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem737 {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1 == null || sentence2 == null || sentence1.length != sentence2.length) {
            return false;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (List<String> pair : similarPairs) {
            wordMap.computeIfAbsent(pair.get(0), key -> wordMap.size());
            wordMap.computeIfAbsent(pair.get(1), key -> wordMap.size());
        }
        int[] parent = new int[wordMap.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (List<String> pair : similarPairs) {
            int x = wordMap.get(pair.get(0));
            int y = wordMap.get(pair.get(1));
            int px = find(parent, x);
            int py = find(parent, y);
            if (px != py) {
                parent[px] = py;
            }
        }
        for (int i = 0; i < sentence1.length; i++) {
            String s1 = sentence1[i];
            String s2 = sentence2[i];
            if (s1.equals(s2)) {
                continue;
            }
            Integer x1 = wordMap.get(s1);
            Integer x2 = wordMap.get(s2);
            if (x1 == null || x2 == null) {
                return false;
            }
            int p1 = find(parent, x1);
            int p2 = find(parent, x2);
            if (p1 != p2) {
                return false;
            }
        }
        return true;
    }

    private int find(int[] parent, int item) {
        if (parent[item] != item) {
            parent[item] = find(parent, parent[item]);
        }
        return parent[item];
    }
}
