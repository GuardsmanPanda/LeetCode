package Problem100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Problem149 {
    public int maxPoints(int[][] points) {
        if (points == null || points.length < 3) {
            return points == null ? 0 : points.length;
        }
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int max = 0;
        HashMap<Double, Integer> slopeMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            slopeMap.clear();
            int[] p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                double slope = p1[0] == p2[0] ? Double.MAX_VALUE : (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
                slopeMap.compute(slope, (k, v) -> v == null ? 2 : v + 1);
            }
            max = Math.max(max, slopeMap.values().stream().mapToInt(Integer::intValue).max().orElse(0));
        }
        return max;
    }
}
