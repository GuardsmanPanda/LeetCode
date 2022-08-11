package Problem1900;

import java.util.Arrays;

public class Problem1937 {
    public long maxPoints(int[][] points) {
        long[][] res = new long[points.length][points[0].length];
        for (int j = 0; j < points[0].length; j++) {
            res[0][j] = points[0][j];
        }
        for (int i = 1; i < points.length; i++) {
            long maxLeft = 0;
            for (int j = 0; j < points[0].length; j++) {
                maxLeft = Math.max(maxLeft - 1, res[i - 1][j]);
                res[i][j] = maxLeft + points[i][j];
            }
            long maxRight = 0;
            for (int j = points[0].length - 1; j >= 0; j--) {
                maxRight = Math.max(maxRight - 1, res[i - 1][j]);
                res[i][j] = Math.max(res[i][j], maxRight + points[i][j]);
            }
        }
        return Arrays.stream(res[res.length -1]).max().orElse(-1);
    }
}
