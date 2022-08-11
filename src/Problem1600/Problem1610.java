package Problem1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> foundAngles = new ArrayList<>();
        int lx = location.get(0);
        int ly = location.get(1);
        int inc = 0;
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if (x == lx && y == ly) {
                inc++;
                continue;
            }
            double v = Math.atan2(y - ly, x - lx);
            foundAngles.add(v);
            foundAngles.add(v + Math.PI*2);
        }
        double[] angles = foundAngles.stream().mapToDouble(Double::doubleValue).toArray();
        Arrays.sort(angles);
        int res = 0;
        int left = 0, right = 0;
        double rangle = Math.toRadians(angle);
        while (right < angles.length) {
            while (right < angles.length && angles[right] - angles[left] <= rangle) {
                //System.out.println("left: " + left + " right: " + right + " angle: " + angles[right] + " - " + angles[left]);
                right++;
            }
            res = Math.max(res, right - left);
            left++;
        }
        return res + inc;
    }
}
