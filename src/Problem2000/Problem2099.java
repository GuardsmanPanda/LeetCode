package Problem2000;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> q1 = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < nums.length; i++) {
            q1.add(new int[]{nums[i], i});
            if (q1.size() > k) {
                q1.poll();
            }
        }
        return q1.stream().sorted(Comparator.comparingInt(a -> a[1]))
                .mapToInt(a -> a[0]).toArray();
    }
}
