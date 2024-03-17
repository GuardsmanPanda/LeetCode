package Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean inserted = false;
        for (int[] ii : intervals) {
            if (ii[1] < newInterval[0]) {
                result.add(ii);
                continue;
            }
            if (ii[0] > newInterval[1]) {
                if (!inserted) {
                    result.add(newInterval);
                    inserted = true;
                }
                result.add(ii);
                continue;
            }
            newInterval[0] = Math.min(newInterval[0], ii[0]);
            newInterval[1] = Math.max(newInterval[1], ii[1]);
        }
        if (!inserted) {
            result.add(newInterval);
        }
        return result.toArray(new int[0][]);
    }
}
