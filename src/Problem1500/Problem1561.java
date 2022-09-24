package Problem1500;

import java.util.Arrays;

public class Problem1561 {
    public int maxCoins(int[] piles) {
        int[] count = new int[10001];
        for (int pile : piles) {
            count[pile]++;
        }
        boolean take = false;
        int res = 0, left = piles.length / 3;
        for (int i = count.length - 1; i >= 0 && left > 0; i--) {
            while (count[i] > 0 && left > 0) {
                if (take) {
                    res += i;
                    left--;
                }
                take = !take;
                count[i]--;
            }
        }
        return res;
    }
}
