package Problem2400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem2406 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        TreeMap<Integer, Integer> ends = new TreeMap<>();
        int res = 0;
        for (int[] i : intervals) {
            var key = ends.lowerKey(i[0]);
            if (key == null) {
                res++;
            } else {
                ends.compute(key, (k, v) -> v == 1 ? null : v - 1);
            }
            ends.compute(i[1], (k, v) -> v == null ? 1 : v + 1);
        }
        return res;
    }
}
