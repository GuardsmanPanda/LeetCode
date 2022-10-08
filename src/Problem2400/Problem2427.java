package Problem2400;

import java.util.stream.IntStream;

public class Problem2427 {
    public int commonFactors(int a, int b) {
        return (int) IntStream.range(1, Math.min(a, b) + 1)
                .filter(i -> a % i == 0 && b % i == 0)
                .count();
    }
}
