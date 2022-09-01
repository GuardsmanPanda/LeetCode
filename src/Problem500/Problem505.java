package Problem500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dist = new int[maze.length][maze[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.add(new int[]{start[0], start[1], 0});
        dist[start[0]][start[1]] = 0;
        while (queue.size() > 0) {
            int[] cur = queue.remove();
            int x = cur[0], y = cur[1];
            if (x == destination[0] && y == destination[1]) {
                return cur[2];
            }
            for (int[] dir : dirs) {
                int nx = x, ny = y, d = cur[2];
                while (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                    d++;
                }
                nx -= dir[0];
                ny -= dir[1];
                d--;
                if (dist[nx][ny] > d) {
                    queue.add(new int[]{nx, ny, d});
                    dist[nx][ny] = d;
                }
            }
        }
        return -1;
    }
}
