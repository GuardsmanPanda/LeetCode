package Problem2400;

import java.util.Arrays;

public class Problem2435 {
    public int numberOfPaths(int[][] grid, int k) {
        int[][] cur = new int[grid[0].length + 1][k];
        cur[1][0] = 1;
        int mod = 1000000007;
        for (int[] a : grid) {
            int[][] next = new int[grid[0].length + 1][k];
            for (int i = 0; i < a.length; i++) {
                for (int kk = 0; kk < k; kk++) {
                    next[i + 1][(kk + a[i]) % k] += next[i][kk] + cur[i + 1][kk];
                    next[i + 1][(kk + a[i]) % k] %= mod;
                }
            }
            cur = next;
        }
        return cur[grid[0].length][0];
    }
}
