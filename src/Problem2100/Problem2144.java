package Problem2100;

import java.util.Arrays;

public class Problem2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            sum += cost[i];
            if (i > 0) {
                sum += cost[i - 1];
            }
        }
        return sum;
    }
}
