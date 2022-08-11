package Problem1700;

import java.util.Arrays;

public class Problem1706 {
    public int[] findBall(int[][] grid) {
        int[] state = new int[grid[0].length];
        for (int i = 0; i < state.length; i++) {
            state[i] = i;
        }
        for (int[] g : grid) {
            int[] next = new int[state.length];
            Arrays.fill(next, -1);
            for (int i = 0; i < state.length; i++) {
                if (i < state.length - 1 && g[i] == 1 && g[i + 1] == -1) {
                    state[i + 1] = -1;
                    state[i] = -1;
                }
                if (g[i] == 1 && state[i] != -1 && i < state.length - 1) {
                    next[i+ 1] = state[i];
                }
                if (g[i] == -1 && state[i] != -1 && i > 0) {
                    next[i - 1] = state[i];
                }
            }
            state = next;
        }
        int[] res = new int[state.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < state.length; i++) {
            if (state[i] != -1) {
                res[state[i]] = i;
            }
        }
        return res;
    }
}
