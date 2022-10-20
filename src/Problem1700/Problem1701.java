package Problem1700;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1701 {
    public double averageWaitingTime(int[][] customers) {
        Arrays.sort(customers, Comparator.comparingInt(a -> a[0]));
        double totalWaitTime = 0;
        int time = 0;
        for (int[] c : customers) {
            time = Math.max(time, c[0]) + c[1];
            totalWaitTime += time - c[0];
        }
        return totalWaitTime / customers.length;
    }
}
