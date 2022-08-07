import java.util.Arrays;

public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (count[i - coin] != Integer.MAX_VALUE) {
                    count[i] = Math.min(count[i], count[i - coin] + 1);
                }
            }
        }
        return count[amount] != Integer.MAX_VALUE ? count[amount] : -1;
    }
}
