package Problem1100;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem1066 {
    public int assignBikes(int[][] workers, int[][] bikes) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] cost = new int[1 << bikes.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        queue.add(0);
        cost[0] = 0;
        for (int[] bike : bikes) {
            for (int i = queue.size(); i > 0; i--) {
                int q = queue.removeFirst();
                for (int k = 0; k < workers.length; k++) {
                    if ((q & (1 << k)) != 0) {
                        continue;
                    }
                    int newCost = cost[q] + Math.abs(workers[k][0] - bike[0]) + Math.abs(workers[k][1] - bike[1]);
                    int newState = q | (1 << k);
                    if (cost[newState] == Integer.MAX_VALUE) {
                        queue.add(newState);
                    }
                    cost[newState] = Math.min(cost[newState], newCost);
                }
                queue.addLast(q);
            }
        }
        return cost[(1 << workers.length) - 1];
    }
}
