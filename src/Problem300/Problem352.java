package Problem300;

import java.util.TreeMap;

public class Problem352 {
    public class SummaryRanges {
        private final TreeMap<Integer, int[]> intervalMap = new TreeMap<>();

        public void addNum(int val) {
            var before = intervalMap.floorEntry(val);
            int[] arr = (before == null || before.getValue()[1] + 1 < val) ? new int[] {val, val} : before.getValue();
            arr[1] = Math.max(arr[1], val);
            var after = intervalMap.get(val + 1);
            if (after != null) {
                arr[1] = after[1];
                intervalMap.remove(after[0]);
            }
            intervalMap.put(arr[0], arr);
        }

        public int[][] getIntervals() {
            return intervalMap.values().toArray(new int[0][]);
        }
    }
}
