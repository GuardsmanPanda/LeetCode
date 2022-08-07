import java.util.ArrayDeque;

public class Problem2174 {
    public int removeOnes(int[][] grid) {
        ArrayDeque<int[][]> queue = new ArrayDeque<>();
        queue.add(grid);
        int steps = 0, front = 1;
        while (queue.size() > 0) {
            int[][] cur = queue.removeFirst();
            boolean found = false;
            for (int i = 0; i < cur.length; i++) {
                for (int j = 0; j < cur[0].length; j++) {
                    if (cur[i][j] == 1) {
                        found = true;
                        int[][] next = new int[cur.length][cur[0].length];
                        for (int in = 0; in < grid.length; in++) {
                            for (int jn = 0; jn < grid[0].length; jn++) {
                                next[in][jn] = (in == i || jn == j) ? 0 : cur[in][jn];
                            }
                        }
                        queue.add(next);
                    }
                }
            }
            if (!found) {
                return steps;
            }
            if (--front == 0) {
                front = queue.size();
                steps++;
            }
        }
        return -1;
    }
}
