package Problem300;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem317 {
    public int shortestDistance(int[][] grid) {
        int houseCount = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                houseCount += anInt & 1;
            }
        }
        boolean[] visited = new boolean[grid.length * grid[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minTotalDistance = Integer.MAX_VALUE;

        int[] xpos = new int[grid.length * grid[0].length];
        int[] ypos = new int[grid.length * grid[0].length];
        int[] dist = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                int totalDistance = 0, foundCount = 0, idx = 0, len = 1;
                xpos[0] = i;
                ypos[0] = j;
                dist[0] = 0;
                Arrays.fill(visited, false);
                visited[i * grid[0].length + j] = true;
                while (idx < len) {
                    int xx = xpos[idx], yy = ypos[idx], dd = dist[idx++];
                    for (int[] dir : dirs) {
                        int x = xx + dir[0], y = yy + dir[1];
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x * grid[0].length + y] || grid[x][y] == 2) {
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            totalDistance += dd + 1;
                            foundCount++;
                        } else {
                            xpos[len] = x;
                            ypos[len] = y;
                            dist[len++] = dd + 1;
                        }
                        visited[x * grid[0].length + y] = true;
                    }
                }
                if (foundCount == houseCount) {
                    minTotalDistance = Math.min(minTotalDistance, totalDistance);
                }
            }
        }
        return minTotalDistance == Integer.MAX_VALUE ? -1 : minTotalDistance;
    }
}
