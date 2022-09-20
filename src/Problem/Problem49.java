package Problem;

import java.util.*;

public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaMap = new HashMap<>();
        List<List<String>> output = new ArrayList<>();
        for (String s : strs) {
            String key = sortedChars(s);
            if (!anaMap.containsKey(key)) {
                List<String> wordList = new ArrayList<>();
                wordList.add(s);
                anaMap.put(key, wordList);
                output.add(wordList);
            } else {
                anaMap.get(key).add(s);
            }
        }
        return output;
    }

    private String sortedChars(String word) {
        char[] ca = word.toCharArray();
        Arrays.sort(ca);
        return new String(ca);
    }
}
