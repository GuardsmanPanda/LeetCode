package Problem2300;

import java.util.Arrays;

public class Problem2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int res = amount[0];
        if (amount[2] <= amount[0] + amount[1]) {
            return (amount[0] + amount[1] + amount[2] + 1) / 2;
        }
        amount[2] -= amount[0];
        return res + Math.max(amount[2], amount[1]);
    }
}
