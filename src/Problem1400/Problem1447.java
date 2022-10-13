package Problem1400;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem1447 {
    public List<String> simplifiedFractions(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed().flatMap(i -> IntStream.range(1, i)
                        .filter(j -> gcd(i, j) == 1)
                        .mapToObj(j -> j + "/" + i))
                .toList();
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
