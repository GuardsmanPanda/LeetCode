import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem127 {
    // x*x*pi -> x/2*x/2*pi -> x*x*pi / 4
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<Integer>> connections = new ArrayList<>();
        int target = -1;
        for (int i = 0; i < wordList.size(); i++) connections.add(new ArrayList<>());
        for (int i = 0; i < wordList.size(); i++) {
            if (endWord.equals(wordList.get(i))) target = i;
            for (int j = i+1; j < wordList.size(); j++) {
                if (areWordsConnected(wordList.get(i), wordList.get(j))) {
                    connections.get(i).add(j);
                    connections.get(j).add(i);
                }
            }
        }
        if (target == -1) return 0;
        //add all words that the begin connects to
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            if (areWordsConnected(beginWord, wordList.get(i))) {
                visited[i] = true;
                queue.addLast(i);
            }
        }
        //traverse graph and find path length
        int pathLength = 2;
        int levelSize = queue.size();
        while (queue.size() > 0) {
            int node = queue.removeFirst();
            levelSize--;
            if (node == target) return pathLength;
            for (Integer otherNode : connections.get(node)) {
                if (!visited[otherNode]) {
                    visited[otherNode] = true;
                    queue.addLast(otherNode);
                }
            }
            if (levelSize == 0) {
                pathLength++;
                levelSize = queue.size();
            }
        }
        return 0;
    }
    private boolean areWordsConnected(String w1, String w2) {
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
