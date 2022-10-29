package Problem1400;

import java.util.Arrays;

public class Problem1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] minCost = new int[m][target][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < target; j++) {
                Arrays.fill(minCost[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < n; i++) {
            if (houses[0] == 0 || houses[0] == i + 1) {
                minCost[0][0][i] = houses[0] == 0 ? cost[0][i] : 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < target; j++) {
                int start = houses[i] == 0 ? 0 : houses[i] - 1;
                int end = houses[i] == 0 ? n : houses[i];
                for (int k = start; k < end; k++) {
                    int costToPaint = houses[i] == 0 ? cost[i][k] : 0;
                    if (j == 0 && minCost[i - 1][j][k] != Integer.MAX_VALUE) {
                        minCost[i][j][k] = minCost[i - 1][j][k] + costToPaint;
                    } else if (j > 0) {
                        for (int l = 0; l < n; l++) {
                            if (l != k && minCost[i - 1][j - 1][l] != Integer.MAX_VALUE) {
                                minCost[i][j][k] = Math.min(minCost[i][j][k], minCost[i - 1][j - 1][l] + costToPaint);
                            } else if (l == k && minCost[i - 1][j][l] != Integer.MAX_VALUE) {
                                minCost[i][j][k] = Math.min(minCost[i][j][k], minCost[i - 1][j][l] + costToPaint);
                            }
                        }
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, minCost[m - 1][target - 1][i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
