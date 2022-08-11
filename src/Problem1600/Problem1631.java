package Problem1600;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1631 {
    public int minimumEffortPath(int[][] heights) {
        boolean[][] vis = new boolean[heights.length][heights[0].length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.add(new int[]{0, 0, 0});
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (queue.size() > 0) {
            int[] cur = queue.remove();
            vis[cur[0]][cur[1]] = true;
            if (cur[0] == heights.length - 1 && cur[1] == heights[0].length - 1) {
                return cur[2];
            }
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !vis[x][y]) {
                    queue.add(new int[]{x, y, Math.max(cur[2], Math.abs(heights[x][y] - heights[cur[0]][cur[1]]))});
                }
            }
        }
        return -1;
    }
}
