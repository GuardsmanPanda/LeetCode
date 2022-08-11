package Problem1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1258 {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Integer> wordMap = new HashMap<>();
        List<String> integerToWord = new ArrayList<>();

        for (List<String> synonym : synonyms) {
            for (String s : synonym) {
                wordMap.computeIfAbsent(s, key -> {
                    integerToWord.add(s);
                    return wordMap.size();
                });
            }
        }
        int[] parent = new int[wordMap.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (List<String> synonym : synonyms) {
            int x = wordMap.get(synonym.get(0));
            int y = wordMap.get(synonym.get(1));
            int px = find(parent, x);
            int py = find(parent, y);
            if (px != py) {
                parent[px] = py;
            }
        }
        Map<Integer, List<Integer>> synMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int p = find(parent, i);
            synMap.computeIfAbsent(p, key -> new ArrayList<>()).add(i);
        }
        List<String> res = new ArrayList<>();
        generate(0, text.split(" "), synMap, wordMap, integerToWord, res, parent, new StringBuilder());
        res.sort(String::compareTo);
        return res;
    }

    private void generate(int index, String[] words, Map<Integer, List<Integer>> synMap, Map<String, Integer> wordMap, List<String> integerToWord, List<String> output, int[] parent, StringBuilder sb) {
        if (index == words.length) {
            sb.setLength(sb.length() - 1);
            output.add(sb.toString());
            sb.append(" ");
            return;
        }
        String cur = words[index];
        if (wordMap.containsKey(cur)) {
            int p = find(parent, wordMap.get(cur));
            for (int i : synMap.get(p)) {
                String w = integerToWord.get(i);
                sb.append(w).append(" ");
                generate(index + 1, words, synMap, wordMap, integerToWord, output, parent, sb);
                sb.setLength(sb.length() - 1 - w.length());
            }
        } else {
            sb.append(cur).append(" ");
            generate(index + 1, words, synMap, wordMap, integerToWord, output, parent, sb);
            sb.setLength(sb.length() - 1 - cur.length());
        }
    }

    private int find(int[] parent, int item) {
        return parent[item] == item ? item : (parent[item] = find(parent, parent[item]));
    }
}
