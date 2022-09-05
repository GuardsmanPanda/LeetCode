package Problem800;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        int[] colors = new int[N+1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= N; i++) {
            if (colors[i] != 0) continue;
            queue.add(i);
            colors[i] = 1;
            while (!queue.isEmpty()) {
                int node = queue.removeFirst();
                int targetColor = colors[node] * -1;
                for (Integer adj : graph.get(node)) {
                    if (colors[adj] == 0) {
                        colors[adj] = targetColor;
                        queue.addLast(adj);
                    }
                    else if (colors[adj] != targetColor)
                        return false;
                }
            }
        }
        return true;
    }
}
