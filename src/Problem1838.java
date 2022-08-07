import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;

public class Problem1838 {
    public int maxFrequency(int[] nums, int k) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int queueCost = 0;
        int queueSize = 0;
        int lastVal = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int val = entry.getKey();
            int cnt = entry.getValue();
            queueCost += queueSize * (val - lastVal);
            queueSize += cnt;
            queue.addFirst(new int[]{val, cnt});

            var last = queue.peekLast();
            while (queueCost > k) {
                int toRemove = (queueCost-k + val - last[0] - 1) / (val - last[0]);
                if (toRemove >= last[1]) {
                    queueCost -= (val - last[0]) * last[1];
                    queueSize -= last[1];
                    queue.removeLast();
                } else {
                    last[1] -= toRemove;
                    queueCost -= (val - last[0]) * toRemove;
                    queueSize -= toRemove;
                }
                last = queue.peekLast();
            }
            max = Math.max(max, queueSize);
            System.out.println("val: " + val + " cnt: " + cnt + " queueCost: " + queueCost + " queueSize: " + queueSize);
            lastVal = val;
        }
        return max;
    }
}
