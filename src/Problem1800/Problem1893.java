package Problem1800;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] seen = new boolean[51];
        Arrays.stream(ranges).forEach(range -> IntStream.rangeClosed(range[0], range[1]).forEach(i -> seen[i] = true));
        return IntStream.rangeClosed(left, right).allMatch(i -> seen[i]);
    }
}
