package Problem800;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem895 {
    class FreqStack {
        private final PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] != o1[1] ? o2[1] - o1[1] : o2[2] - o1[2];
            }
        });
        private int id = 0;
        private HashMap<Integer, Integer> count = new HashMap<>();

        public FreqStack() {

        }

        public void push(int x) {
            int cc = count.compute(x, (k, v) -> v == null ? 1 : v + 1);
            queue.add(new int[]{x, cc, id++});
        }

        public int pop() {
            int item = queue.remove()[0];
            count.computeIfPresent(item, (k, v) -> v - 1);
            return item;
        }
    }
}
