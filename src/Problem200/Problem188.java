package Problem200;

import java.util.Arrays;

public class Problem188 {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int p : prices) {
            for (int i = 1; i < k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - p);
                sell[i] = Math.max(sell[i], buy[i] + p);
            }
            System.out.println(p);
            System.out.println(Arrays.toString(buy));
            System.out.println(Arrays.toString(sell));
        }
        int res = 0;
        for (int i = 1; i < k; i++) {
            res = Math.max(res, sell[i]);
        }
        return res;
    }
}
