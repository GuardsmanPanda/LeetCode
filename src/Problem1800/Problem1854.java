package Problem1800;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1854 {
    public int maximumPopulation(int[][] logs) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = 0, res = 0, year = 0;
        for (int[] log : logs) {
            queue.add(log[1]);
            year = log[0];
            while (!queue.isEmpty() && queue.peek() <= year) {
                queue.remove();
            }
            if (queue.size() > max) {
                max = queue.size();
                res = year;
            }
        }
        return res;
    }
}
