package Problem1500;

import java.util.stream.IntStream;

public class Problem1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        return IntStream.range(2, arr.length).anyMatch(i -> arr[i] % 2 == 1 && arr[i - 1] % 2 == 1 && arr[i - 2] % 2 == 1);
    }
}
