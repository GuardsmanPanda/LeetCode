package Problem500;

import java.util.Arrays;
import java.util.Comparator;

public class Problem435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int lastEnd = intervals[0][1], removed = -1;
        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                lastEnd = interval[1];
            } else {
                removed++;
            }
        }
        return removed;
    }
}
