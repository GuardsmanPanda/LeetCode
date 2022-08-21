package Problem1300;

import java.util.Map;
import java.util.PriorityQueue;

public class Problem1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : arr) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(map.values());
        int target = (arr.length + 1) / 2;
        int res = 0;
        while (target > 0) {
            target -= queue.remove();
            res++;
        }
        return res;
    }
}
