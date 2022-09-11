package Problem1300;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1383 {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0, max = 0;
        for (int[] engineer : engineers) {
            pq.offer(engineer[0]);
            sum += engineer[0];
            if (pq.size() > k) {
                sum -= pq.remove();
            }
            max = Math.max(max, sum * engineer[1]);
        }
        return (int) (max % 1000000007);
    }
}
