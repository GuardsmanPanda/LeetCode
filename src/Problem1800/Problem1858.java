package Problem1800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem1858 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? b.compareTo(a) : a.length() - b.length());
        String result = "";
        List<int[]> trie = new ArrayList<>();
        int[] root = new int[27];
        root[26] = 1;
        trie.add(root);
        for (String word : words) {
            int[] node = root;
            boolean prefixFound = true;
            for (int i = 0; i < word.length(); i++) {
                prefixFound &= node[26] == 1;
                int index = word.charAt(i) - 'a';
                if (node[index] == 0) {
                    node[index] = trie.size();
                    trie.add(new int[27]);
                }
                node = trie.get(node[index]);
            }
            if (prefixFound) {
                result = word;
            }
            node[26] = 1;
        }
        return result;
    }
}
