package Problem1100;

import java.util.Arrays;

public class Problem1196 {
    public int maxNumberOfApples(int[] weight) {
        int[] sum = {5000};
        return (int) Arrays.stream(weight)
                .sorted()
                .takeWhile(i -> (sum[0] -= i) >= 0)
                .count();
    }
}
