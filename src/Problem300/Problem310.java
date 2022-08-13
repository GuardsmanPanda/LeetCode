package Problem300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (queue.size() > 0) {
            res.clear();
            res.addAll(queue);
            for (int i = queue.size(); i > 0 ; i--) {
                int cur = queue.removeFirst();
                for (Integer adj : graph.get(cur)) {
                    if (--degree[adj] == 1) {
                        queue.addLast(adj);
                    }
                }
            }
        }
        return res;
    }
}
