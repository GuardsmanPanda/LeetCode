package Problem2400;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2448 {
    public long minCost(int[] nums, int[] cost) {
        int[][] values = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            values[i][0] = nums[i];
            values[i][1] = cost[i];
        }
        Arrays.sort(values, Comparator.comparingInt(a -> a[0]));
        long[] costLeft = new long[nums.length];
        long curCost = 0, curInc = 0, lastValue = 0;
        for (int i = 0; i < values.length; i++) {
            long val = values[i][0];
            curCost += curInc * (val - lastValue);
            curInc += values[i][1];
            costLeft[i] = curCost;
            lastValue = val;
        }
        long result = Long.MAX_VALUE;
        lastValue = 0;
        curCost = 0;
        curInc = 0;
        for (int i = values.length - 1; i >= 0; i--) {
            long val = values[i][0];
            curCost += curInc * (lastValue - val);
            curInc += values[i][1];
            result = Math.min(result, costLeft[i] + curCost);
            lastValue = val;
        }
        return result;
    }
}
