package Problem200;

import java.util.ArrayDeque;

public class Problem286 {
    public void wallsAndGates(int[][] rooms) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.addLast(new int[]{i, j});
                }
            }
        }
        int step = 1, front = queue.size();
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (queue.size() > 0) {
            var cur = queue.removeFirst();
            for (int[] d : dir) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = step;
                    queue.addLast(new int[]{x, y});
                }
            }
            if (--front == 0) {
                front = queue.size();
                step++;
            }
        }
    }
}
