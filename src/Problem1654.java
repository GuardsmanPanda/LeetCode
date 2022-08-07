import java.util.ArrayDeque;

public class Problem1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[2][6000];
        for (int i : forbidden) {
            vis[0][i] = true;
            vis[1][i] = true;
        }
        q.add(new int[]{0, 0});
        vis[0][0] = true;

        int step = 0, front = 1;
        while (q.size() > 0) {
            int[] cur = q.removeFirst();
            if (cur[0] == x) {
                return step;
            }
            if (cur[0] + a < vis[0].length && !vis[0][cur[0] + a]) {
                q.addLast(new int[]{cur[0] + a, 0});
                vis[0][cur[0] + a] = true;
            }
            if (cur[1] < 1 && cur[0] - b >= 0 && !vis[cur[1] + 1][cur[0] - b]) {
                q.addLast(new int[]{cur[0] - b, cur[1] + 1});
                vis[cur[1] + 1][cur[0] - b] = true;
            }
            if (--front == 0) {
                front = q.size();
                step++;
            }
        }
        return -1;
    }
}
