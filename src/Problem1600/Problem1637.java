package Problem1600;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Problem1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        return IntStream.range(0, points.length - 1)
                .map(i -> points[i + 1][0] - points[i][0])
                .max().orElse(0);
    }
}
