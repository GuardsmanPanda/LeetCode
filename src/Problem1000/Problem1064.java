package Problem1000;

import java.util.stream.IntStream;

public class Problem1064 {
    public int fixedPoint(int[] arr) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == i).findFirst().orElse(-1);
    }
}
