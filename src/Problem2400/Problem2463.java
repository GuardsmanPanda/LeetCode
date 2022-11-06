package Problem2400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem2463 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int[] r = robot.stream().mapToInt(i -> i).sorted().toArray();
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        long[][] cost = new long[factory.length + 1][r.length + 1];
        for (long[] longs : cost) {
            Arrays.fill(longs, Long.MAX_VALUE);
        }
        cost[0][0] = 0;
        for (int i = 1; i <= factory.length; i++) {
            long pos = factory[i - 1][0], limit = factory[i - 1][1];
            for (int j = 0; j <= r.length; j++) {
                long sum = cost[i - 1][j];
                if (sum == Long.MAX_VALUE) {
                    continue;
                }
                cost[i][j] = Math.min(cost[i][j], sum);
                for (int k = 0; k < limit && j + k < r.length; k++) {
                    sum += Math.abs(r[j + k] - pos);
                    cost[i][j + k + 1] = Math.min(cost[i][j + k + 1], sum);
                }
            }
            System.out.println(Arrays.toString(cost[i]));
        }
        return cost[factory.length][r.length];
    }
}
