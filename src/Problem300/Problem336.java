package Problem300;

import java.util.ArrayList;
import java.util.List;

public class Problem336 {
    private static class TrieNode {
        public final TrieNode[] children = new TrieNode[26];
        public int word = -1;
    }

    public List<List<Integer>> palindromePairs(String[] words) { // O(n * len(word) * len(word))
        TrieNode revRoot = new TrieNode();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (char c : words[i].toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = i;
            node = revRoot;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                char c = words[i].charAt(j);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = i;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            String w = words[i];
            if (node.word != -1 && node.word != i && isPalindrome(w, 0, w.length() - 1)) {
                result.add(List.of(i, node.word));
                result.add(List.of(node.word, i));
            }
            for (int j = w.length() - 1; j >= 0; j--) {
                char c = w.charAt(j);
                if (node.children[c - 'a'] == null) {
                    break;
                }
                node = node.children[c - 'a'];
                if (node.word != -1 && node.word != i && isPalindrome(w, 0, j - 1)) {
                    result.add(List.of(node.word, i));
                }
            }
            node = revRoot;
            for (int j = 0; j < w.length(); j++) {
                char c = w.charAt(j);
                if (node.children[c - 'a'] == null) {
                    break;
                }
                node = node.children[c - 'a'];
                if (node.word != -1 && w.length() != words[node.word].length() && isPalindrome(w, j + 1, w.length() - 1)) {
                    result.add(List.of(i, node.word));
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
