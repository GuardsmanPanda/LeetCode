package Problem700;

import java.util.TreeMap;

public class Problem732 {
    class MyCalendarThree {
        private final TreeMap<Integer, Integer> map = new TreeMap<>();

        public int book(int start, int end) {
            map.compute(start, (k, v) -> v == null ? 1 : v + 1);
            map.compute(end, (k, v) -> v == null ? -1 : v - 1);
            int max = 0;
            int sum = 0;
            for (int v : map.values()) {
                sum += v;
                max = Math.max(max, sum);
            }
            return max;
        }
    }
}