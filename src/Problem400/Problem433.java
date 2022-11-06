package Problem400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem433 {
    public int minMutation(String start, String end, String[] bank) {
        List<List<Integer>> graph = new ArrayList<>();
        int target = -1;
        for (int i = 0; i < bank.length; i++) {
            if (target == -1 && end.equals(bank[i])) target = i;
            graph.add(new ArrayList<>());
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[bank.length];
        for (int i = 0; i < bank.length; i++) {
            if (isConnected(start, bank[i])) {
                visited[i] = true;
                queue.addLast(i);
            }
            for (int j = i+1; j < bank.length; j++) {
                if (isConnected(bank[i], bank[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int frontier = queue.size(), mutations = 1;
        while (queue.size() > 0) {
            int pos = queue.removeFirst();
            frontier--;
            if (pos == target) return mutations;
            for (Integer adj : graph.get(pos)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.addLast(adj);
                }
            }
            if (frontier == 0) {
                frontier = queue.size();
                mutations++;
            }
        }
        return -1;
    }
    private boolean isConnected(String s1, String s2) {
        boolean found = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (!found) found = true;
                else return false;
            }
        }
        return true;
    }
}
