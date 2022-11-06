package Problem700;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem778 {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        int max = grid[0][0];
        visited[0][0] = true;
        queue.add(new int[] {0, 0, max});
        while (!queue.isEmpty()) {
            int[] node = queue.remove();
            max = Math.max(max, node[2]);
            if (node[0] == grid.length-1 && node[1] == grid[0].length-1)
                return max;
            for (int[] dir : directions) {
                int x = node[0] + dir[0], y = node[1] + dir[1];
                if (x<0 || y<0 || x>=grid.length || y>= grid[0].length ||visited[x][y])
                    continue;
                visited[x][y] = true;
                queue.add(new int[] {x, y, grid[x][y]});
            }
        }
        return -1;
    }
}
