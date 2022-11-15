package Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean overlap = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] < newInterval[1] && cur[1] > newInterval[0]) {
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
                while (i < intervals.length - 1 && intervals[i + 1][0] <= newInterval[1]) {
                    cur = intervals[i + 1];
                    newInterval[1] = Math.max(newInterval[1], cur[1]);
                    i++;
                }
                overlap = true;
                res.add(newInterval);
            } else {
                res.add(cur);
            }
        }
        if (!overlap) {
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i)[0] > newInterval[1]) {
                    res.add(i, newInterval);
                    overlap = true;
                    break;
                }
            }
            if (!overlap) {
                res.add(newInterval);
            }
        }
        return res.toArray(new int[0][]);
    }
}
