package Problem2300;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem2360 {
    public int longestCycle(int[] edges) {
        boolean[] visited = new boolean[edges.length];
        int[] inDeg = new int[edges.length];
        for (int edge : edges) {
            if (edge == -1) continue;
            inDeg[edge]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < edges.length; i++) {
            if (inDeg[i] == 0) {
                visited[i] = true;
                queue.add(i);
            }
        }
        while (queue.size() > 0) {
            int cur = queue.poll();
            int next = edges[cur];
            if (next == -1) continue;
            if (--inDeg[next] == 0) {
                visited[next] = true;
                queue.add(next);
            }
        }
        int max = -1;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            int next = edges[i];
            visited[i] = true;
            int counter = 1;
            while (next != i) {
                visited[next] = true;
                next = edges[next];
                counter++;
            }
            max = Math.max(max, counter);
        }
        return max;
    }
}
