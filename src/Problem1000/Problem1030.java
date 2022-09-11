package Problem1000;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Problem1030 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        return IntStream.range(0, rows).boxed()
                .flatMap(r -> IntStream.range(0, cols).mapToObj(c -> new int[]{r, c}))
                .sorted(Comparator.comparingInt(a -> Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)))
                .toArray(int[][]::new);
    }
}
