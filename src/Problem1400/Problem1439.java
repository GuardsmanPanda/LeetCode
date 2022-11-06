package Problem1400;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1439 {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(0);
        for (int[] num : mat) {
            PriorityQueue<Integer> temp = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i : queue) {
                for (int j : num) {
                    temp.add(i + j);
                    if (temp.size() > k) {
                        temp.remove();
                    }
                }
            }
            queue = temp;
        }
        return queue.remove();
    }
}
