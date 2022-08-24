package Problem800;

import java.util.Arrays;

public class Problem879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] ways = new int[group.length + 1][n + 1][minProfit + 1];
        int mod = 1000000007;
        ways[0][0][0] = 1;
        for (int i = 1; i <= group.length; i++) {
           // System.out.println("i = " + i);
            int peopleNeeded = group[i - 1];
            for (int people = 0; people <= n; people++) {
                for (int p = 0; p <= minProfit; p++) {
                    ways[i][people][p] += ways[i - 1][people][p];
                    ways[i][people][p] %= mod;
                    if (people >= peopleNeeded) {
                        int newProfit = Math.min(minProfit, p + profit[i - 1]);
                        ways[i][people][newProfit] += ways[i - 1][people - peopleNeeded][p];
                        ways[i][people][newProfit] %= mod;
                    }
                }
            }
           // for (int[] ints : ways[i]) {
           //     System.out.println(Arrays.toString(ints));
           // }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += ways[group.length][i][minProfit];
            res %= mod;
        }
        return res;
    }
}
