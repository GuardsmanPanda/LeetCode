package Problem1100;

import java.util.Arrays;
import java.util.List;

public class Problem1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[][] dist = new int[3][colors.length];
        boolean[] found = new boolean[3];
        int[] lastIdx = {-1_000_000, -1_000_000, -1_000_000};
        for (int i = 0; i < colors.length; i++) {
            int c = colors[i] - 1;
            lastIdx[c] = i;
            dist[0][i] = i - lastIdx[0];
            dist[1][i] = i - lastIdx[1];
            dist[2][i] = i - lastIdx[2];
            found[c] = true;
        }
        lastIdx = new int[] {1_000_000, 1_000_000, 1_000_000};
        for (int i = colors.length - 1; i >= 0; i--) {
            int c = colors[i] - 1;
            lastIdx[c] = i;
            dist[0][i] = Math.min(lastIdx[0] - i, dist[0][i]);
            dist[1][i] = Math.min(lastIdx[1] - i, dist[1][i]);
            dist[2][i] = Math.min(lastIdx[2] - i, dist[2][i]);
        }
        return Arrays.stream(queries)
                .map(q -> found[q[1] - 1] ? dist[q[1] - 1][q[0]] : -1)
                .toList();
    }
}
