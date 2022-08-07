import java.util.ArrayList;
import java.util.List;

public class Problem1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            TrieNode node = root;
            for (char c : product.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                node.prefixes.add(product);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            int idx = c - 'a';
            root = root.children[idx];
            if (root != null) {
                result.add(root.prefixes.stream().sorted().limit(3).toList());
            } else {
               break;
            }
        }
        while (result.size() < searchWord.length()) {
            result.add(new ArrayList<>());
        }
        return result;
    }

    public static class TrieNode {
        public final List<String> prefixes = new ArrayList<>();
        public final TrieNode[] children = new TrieNode[26];
    }
}
