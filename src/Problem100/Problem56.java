package Problem100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur = {intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > cur[1]) {
                res.add(cur);
                cur = new int[]{intervals[i][0], intervals[i][1]};
            } else {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
        }
        res.add(cur);
        return res.toArray(new int[0][]);
    }
}
