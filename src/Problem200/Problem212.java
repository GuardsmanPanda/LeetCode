package Problem200;

import java.util.*;

public class Problem212 {
    private class TrieNode {
        public boolean endNode = false;
        public final HashMap<Character, TrieNode> children = new HashMap<>();
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) node.children.put(c, new TrieNode());
                node = node.children.get(c);
            }
            node.endNode = true;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                recursiveWordSearch(i, j, root, board, visited, builder);
            }
        }
        return output;
    }
    private List<String> output = new ArrayList<>();
    private Set<String> found = new HashSet<>();
    private int[] yDir = {-1,0,1,0};
    private int[] xDir = {0,1,0,-1};
    private void recursiveWordSearch(int y, int x, TrieNode node, char[][] board, boolean[][] visited, StringBuilder builder) {
        if (y<0 || x<0 || y>=board.length || x>=board[0].length || visited[y][x]) return;
        char c = board[y][x];
        if (!node.children.containsKey(c)) return;

        node = node.children.get(c);
        builder.append(c);
        if (node.endNode) {
            String word = builder.toString();
            if (!found.contains(word)) {
                output.add(word);
                found.add(word);
            }
        }
        visited[y][x] = true;
        for (int i = 0; i < yDir.length; i++) {
            recursiveWordSearch(y+yDir[i], x+xDir[i], node, board, visited, builder);
        }
        builder.setLength(builder.length()-1);
        visited[y][x] = false;
    }
}
