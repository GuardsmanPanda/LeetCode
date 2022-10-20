package Problem1700;

import java.util.ArrayDeque;

public class Problem1765 {
    public int[][] highestPeak(int[][] isWater) {
        int[][] res = new int[isWater.length][isWater[0].length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                } else {
                    res[i][j] = -1;
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int height = 0, size = queue.size();
        while (queue.size() > 0) {
            int[] node = queue.removeFirst();
            res[node[0]][node[1]] = height;
            for (int[] dir : dirs) {
                int x = node[0] + dir[0], y = node[1] + dir[1];
                if (x >= 0 && x < isWater.length && y >= 0 && y < isWater[0].length && res[x][y] == -1) {
                    queue.add(new int[]{x, y});
                    res[x][y] = 0;
                }
            }
            if (--size == 0) {
                size = queue.size();
                height++;
            }
        }
        return res;
    }
}
