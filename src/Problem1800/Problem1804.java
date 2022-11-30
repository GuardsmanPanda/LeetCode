package Problem1800;

public class Problem1804 {
    class Trie {
        record TrieNode(int[] count, TrieNode[] children) {
            public TrieNode() {
                this(new int[2], new TrieNode[26]);
            }
        }
        private final TrieNode root = new TrieNode();

        public void insert(String word) {
            traverse(root, word.toCharArray(), 1);
        }

        public int countWordsEqualTo(String word) {
            return traverse(root, word.toCharArray(), 0).count[1];
        }

        public int countWordsStartingWith(String prefix) {
            return traverse(root, prefix.toCharArray(), 0).count[0];
        }

        public void erase(String word) {
            traverse(root, word.toCharArray(), -1);
        }

        private TrieNode traverse(TrieNode node, char[] arr, int modify) {
            for (char c : arr) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count[0] += modify;
            }
            node.count[1] += modify;
            return node;
        }
    }
}
