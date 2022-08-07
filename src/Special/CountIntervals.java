package Special;

import java.util.TreeMap;

public class CountIntervals {
    private final TreeMap<Integer, int[]> intervals = new TreeMap<>();
    private int count = 0;

    public void add(int left, int right) {
        var entry = intervals.floorEntry(left - 1);
        int[] cur = null;
        count += right - left + 1;
        if (entry == null || entry.getValue()[1] < left - 1) {
            cur = new int[]{left, right};
        } else {
            cur = entry.getValue();
            count -= Math.min(right, cur[1]) - left + 1;
            cur[1] = Math.max(cur[1], right);
        }
        var next = intervals.ceilingEntry(left);
        while (next != null && next.getValue()[0] <= right) {
            intervals.remove(next.getKey());
            count -= Math.min(cur[1], next.getValue()[1]) - next.getValue()[0] + 1;
            cur[1] = Math.max(cur[1], next.getValue()[1]);
            next = intervals.ceilingEntry(left);
        }
        intervals.put(cur[0], cur);
    }

    public int count() {
        return count;
    }
}
