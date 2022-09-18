package Problem1200;

import java.util.stream.IntStream;

public class Problem1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        return IntStream.range(1, points.length)
                .map(i -> Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1])))
                .sum();
    }
}
