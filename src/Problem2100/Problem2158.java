package Problem2100;

import java.util.TreeMap;

public class Problem2158 {
    public int[] amountPainted(int[][] paint) {
        TreeMap<Integer, int[]> segmentMap = new TreeMap<>();
        int[] result = new int[paint.length];
        for (int i = 0; i < paint.length; i++) {
            int[] p = paint[i];
            result[i] = p[1] - p[0];
            int[] newEntry = {p[0], p[1]};
            var before = segmentMap.lowerEntry(newEntry[0]);
            if (before != null && before.getValue()[1] >= newEntry[0]) {
                segmentMap.remove(before.getKey());
                result[i] -= before.getValue()[1] - newEntry[0];
                newEntry[0] = before.getValue()[0];
                newEntry[1] = Math.max(newEntry[1], before.getValue()[1]);
            }
            var after = segmentMap.ceilingEntry(newEntry[0]);
            while (after != null && after.getKey() <= newEntry[1]) {
                segmentMap.remove(after.getKey());
                result[i] -= Math.min(after.getValue()[1], newEntry[1]) - after.getValue()[0];
                newEntry[1] = Math.max(newEntry[1], after.getValue()[1]);
                after = segmentMap.ceilingEntry(newEntry[0]);
            }
            result[i] = Math.max(0, result[i]);
            segmentMap.put(newEntry[0], newEntry);
        }
        return result;
    }
}
