package Problem1600;

import java.util.Arrays;

public class problem1619 {
    public double trimMean(int[] arr) {
        int skip = arr.length / 20;
        return Arrays.stream(arr).sorted().skip(skip).limit(arr.length - 2 * skip).average().orElse(0);
    }
}
