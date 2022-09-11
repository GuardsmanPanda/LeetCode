package Problem1900;

import java.util.stream.IntStream;

public class Problem1952 {
    public boolean isThree(int n) {
        return IntStream.range(1, n + 1).filter(i -> n % i == 0).count() == 3;
    }
}
