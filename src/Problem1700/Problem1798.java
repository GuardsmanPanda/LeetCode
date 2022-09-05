package Problem1700;

import java.util.Arrays;

public class Problem1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int next = 1;
        for (int coin : coins) {
            if (coin > next)
                break;
            next += coin;
        }
        return next;
    }
}
