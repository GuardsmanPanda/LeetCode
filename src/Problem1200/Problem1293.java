package Problem1200;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem1293 {
    public int shortestPath(int[][] grid, int k) {
        int[][] seen = new int[grid.length][grid[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] a : seen) {
            Arrays.fill(a, k + 1);
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        seen[0][0] = 0;
        int steps = 0, size = 1;
        while (queue.size() > 0) {
            int[] pos = queue.removeFirst();
            int zz = seen[pos[0]][pos[1]];
            if (pos[0] == grid.length - 1 && pos[1] == grid[0].length - 1) {
                return steps;
            }
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0], y = pos[1] + dir[1];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                    continue;
                }
                int z = zz + grid[x][y];
                if (seen[x][y] <= z || grid[x][y] == 1 && z > k) {
                    continue;
                }
                queue.add(new int[]{x, y});
                seen[x][y] = z;
            }
            if (--size == 0) {
                size = queue.size();
                steps++;
            }
        }
        return -1;
    }
}
