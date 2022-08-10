package Problem300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem269 {
    public String alienOrder(String[] words) {
        boolean[][] graph = new boolean[26][26];
        int[] inDegree = new int[26];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                graph[c - 'a'][c - 'a'] = true;
            }
            List<String> remaining = java.util.Arrays.stream(words, i + 1, words.length).toList();
            for (int k = 0; k < word.length() && remaining.size() > 0; k++) {
                char c = word.charAt(k);
                List<String> next = new ArrayList<>();
                for (String other : remaining) {
                    if (k < other.length() && c == other.charAt(k)) {
                        next.add(other);
                    }
                    else if (k < other.length()) {
                        graph[c - 'a'][other.charAt(k) - 'a'] = true;
                    } else if (k == other.length()) {
                        return "";
                    }
                }
                remaining = next;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (graph[i][j] && i != j) {
                    inDegree[j]++;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (graph[i][i] && inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int c = queue.poll();
            sb.append((char) (c + 'a'));
            for (int i = 0; i < 26; i++) {
                if (graph[c][i]) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] > 0) {
                return "";
            }
        }
        return sb.toString();
    }
}
