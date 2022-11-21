package Problem700;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem741 {
    public int cherryPickup(int[][] grid) {
        int[][][][] maxCherries = new int[grid.length][grid.length][grid.length][grid.length];
        for (int[][][] arr1 : maxCherries) {
            for (int[][] arr2 : arr1) {
                for (int[] arr3 : arr2) {
                    Arrays.fill(arr3, Integer.MIN_VALUE);
                }
            }
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        maxCherries[0][0][0][0] = grid[0][0];
        queue.add(new int[]{0, 0, 0, 0});
        int[][] directions = {{1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 0, 1}, {0, 1, 1, 0}};
        while (queue.size() > 0) {
            int[] pos = queue.removeFirst();
            for (int[] d : directions) {
                int x1 = pos[0] + d[0], y1 = pos[1] + d[1], x2 = pos[2] + d[2], y2 = pos[3] + d[3];
                if (x1 < 0 || x1 >= grid.length || y1 < 0 || y1 >= grid.length || x2 < 0 || x2 >= grid.length || y2 < 0 || y2 >= grid.length || grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                    continue;
                }
                int bonus = x1 == x2 && y1 == y2 ? grid[x1][y1] : grid[x1][y1] + grid[x2][y2];
                if (maxCherries[x1][y1][x2][y2] < maxCherries[pos[0]][pos[1]][pos[2]][pos[3]] + bonus) {
                    maxCherries[x1][y1][x2][y2] = maxCherries[pos[0]][pos[1]][pos[2]][pos[3]] + bonus;
                    queue.add(new int[]{x1, y1, x2, y2});
                }
            }
        }
        return Math.max(0, maxCherries[grid.length - 1][grid.length - 1][grid.length - 1][grid.length - 1]);
    }
}
