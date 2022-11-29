package Problem1300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1368 {
    public int minCost(int[][] grid) {
        int[][] cost = new int[grid.length][grid[0].length];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue.add(new int[]{0, 0, 0});
        cost[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            for (int i = 0; i < 4; i++) {
                int[] direction = directions[i];
                int x = pos[0] + direction[0];
                int y = pos[1] + direction[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                    int newCost = cost[pos[0]][pos[1]] + (i == grid[pos[0]][pos[1]] - 1 ? 0 : 1);
                    if (newCost < cost[x][y]) {
                        cost[x][y] = newCost;
                        queue.add(new int[]{x, y, newCost});
                    }
                }
            }
        }
        return cost[grid.length - 1][grid[0].length - 1];
    }
}
