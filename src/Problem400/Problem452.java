package Problem400;

import java.util.Arrays;
import java.util.Comparator;

public class Problem452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int arrows = 1, lastShot = points[0][1], index = 1;
        while (index < points.length) {
            if (lastShot < points[index][0]) {
                lastShot = points[index][1];
                arrows++;
            }
            index++;
        }
        return arrows;
    }
}
