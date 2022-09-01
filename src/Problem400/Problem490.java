package Problem400;

import java.util.ArrayDeque;

public class Problem490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        queue.addFirst(start);
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (queue.size() > 0) {
            int[] cur = queue.removeLast();
            int x = cur[0], y = cur[1];
            if (x == destination[0] && y == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int nx = x, ny = y;
                while (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                }
                nx -= dir[0];
                ny -= dir[1];
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.addFirst(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
