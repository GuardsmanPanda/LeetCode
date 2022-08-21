package Problem900;

import java.util.Arrays;

public class Problem983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cost = new int[days.length + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        for (int i = 0; i < days.length; i++) {
            int cur = cost[i], day = days[i];
            cost[i + 1] = Math.min(cost[i + 1], cur + costs[0]);
            for (int k = i; k < days.length && days[k] < day + 7; k++) {
                cost[k + 1] = Math.min(cost[k + 1], cur + costs[1]);
            }
            for (int k = i; k < days.length && days[k] < day + 30; k++) {
                cost[k + 1] = Math.min(cost[k + 1], cur + costs[2]);
            }
        }
        return cost[days.length];
    }
}
