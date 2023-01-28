package Problem1900;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
        for (int pile : piles) {
            queue.add(pile);
        }
        for (int i = 0; i < k; i++) {
            int pile = queue.remove();
            queue.add(pile - pile / 2);
        }
        return queue.stream().mapToInt(i -> i).sum();
    }
}
