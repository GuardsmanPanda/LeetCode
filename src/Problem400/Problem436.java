package Problem400;

import java.util.Arrays;
import java.util.Comparator;

public class Problem436 {
    public int[] findRightInterval(int[][] intervals) {
        int[][] start = new int[intervals.length][2];
        int[][] end = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            start[i][0] = intervals[i][0];
            start[i][1] = i;
            end[i][0] = intervals[i][1];
            end[i][1] = i;
        }

        int[] result = new int[intervals.length];
        Arrays.sort(start, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(end, Comparator.comparingInt(o -> o[0]));
        int idx = 0;
        for (int[] a : end) {
            int ndx = a[1], right = a[0];
            while (idx < start.length && start[idx][0] < right)
                idx++;
            result[ndx] = idx < start.length ? start[idx][1] : -1;
        }
        return result;
    }
}
