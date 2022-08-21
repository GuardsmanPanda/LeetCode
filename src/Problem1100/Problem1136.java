package Problem1100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem1136 {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] relation : relations) {
            graph.get(relation[0] - 1).add(relation[1] - 1);
            inDegree[relation[1] - 1]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int remain = n, steps = 0;
        while (queue.size() > 0) {
            for (int i = queue.size(); i > 0; i--) {
                int cur = queue.removeFirst();
                graph.get(cur).forEach(next -> {
                    if (--inDegree[next] == 0) {
                        queue.addLast(next);
                    }
                });
                remain--;
            }
            steps++;
        }
        return remain == 0 ? steps : -1;
    }
}
