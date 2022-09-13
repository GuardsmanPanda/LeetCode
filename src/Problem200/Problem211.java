package Problem200;

import java.util.HashMap;

public class Problem211 {
    class WordDictionary {
        private class TrieNode {
            public boolean endNode = false;
            public final HashMap<Character, TrieNode> children = new HashMap<>();
        }
        private TrieNode root = new TrieNode();

        public WordDictionary() { }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) node.children.put(c, new TrieNode());
                node = node.children.get(c);
            }
            node.endNode = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return recursiveSearch(root, word.toCharArray(), 0);
        }

        private boolean recursiveSearch(TrieNode node, char[] chars, int index) {
            if (index == chars.length) return node.endNode;
            char c = chars[index];
            if (c == '.') {
                for (TrieNode trieNode : node.children.values()) {
                    if (recursiveSearch(trieNode, chars, index+1)) return true;
                }
            } else if (node.children.containsKey(c)) {
                return recursiveSearch(node.children.get(c), chars,index+1);
            }
            return false;
        }
    }
}
