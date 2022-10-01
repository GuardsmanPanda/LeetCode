package Problem2400;

import java.util.TreeMap;

public class Problem2424 {
    class LUPrefix {
        private final TreeMap<Integer, Integer> interval = new TreeMap<>();

        public LUPrefix(int n) { }

        public void upload(int video) {
            var lower = interval.lowerEntry(video);
            int start = video;
            if (lower != null && lower.getValue() == video - 1) {
                start = lower.getKey();
            }
            int end = video;
            var higher = interval.higherEntry(video);
            if (higher != null && higher.getKey() == video + 1) {
                interval.remove(video + 1);
                end = higher.getValue();
            }
            interval.put(start, end);
        }

        public int longest() {
            return interval.getOrDefault(1, 0);
        }
    }
}
