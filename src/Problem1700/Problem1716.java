package Problem1700;

import java.util.stream.IntStream;

public class Problem1716 {
    public int totalMoney(int n) {
        return IntStream.range(0, n).map(i -> (i / 7 + 1) + (i % 7)).sum();
    }
}
