package Problem700;

import java.util.Map;
import java.util.TreeMap;

public class Problem715 {
    class RangeModule {
        private final TreeMap<Integer, Integer> ranges = new TreeMap<>();

        public void addRange(int left, int right) {
            var leftEntry = ranges.floorEntry(left);
            if (leftEntry != null && leftEntry.getValue() >= left) {
                left = leftEntry.getKey();
                right = Math.max(leftEntry.getValue(), right);
            }
            while (ranges.floorKey(right) != null && ranges.floorKey(right) > left) {
                right = Math.max(right, ranges.remove(ranges.floorKey(right)));
            }
            ranges.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            var entry = ranges.floorEntry(left);
            return entry != null && entry.getValue() >= right;
        }

        public void removeRange(int left, int right) {
            var low = ranges.lowerEntry(left);
            if (low != null && low.getValue() > left) {
                ranges.put(low.getKey(), left);
                if (low.getValue() >= right) {
                    ranges.put(right, low.getValue());
                }
            }
            var high = ranges.lowerEntry(right);
            while (high != null && high.getValue() > left) {
                ranges.remove(high.getKey());
                if (high.getValue() >= right) {
                    ranges.put(right, high.getValue());
                }
                high = ranges.lowerEntry(right);
            }
        }
    }
}
