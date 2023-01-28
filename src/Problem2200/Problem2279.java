package Problem2200;

import java.util.PriorityQueue;

public class Problem2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < capacity.length; i++) {
            queue.add(capacity[i] - rocks[i]);
        }
        int res = 0;
        while (queue.size() > 0 && queue.peek() <= additionalRocks) {
            additionalRocks -= queue.remove();
            res++;
        }
        return res;
    }
}
