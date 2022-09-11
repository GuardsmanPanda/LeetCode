package Problem2200;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Problem2264 {
    public String largestGoodInteger(String num) {
        return IntStream.range(2, num.length())
                .filter(i -> num.charAt(i - 2) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i))
                .boxed().max(Comparator.comparingInt(num::charAt))
                .map(i -> num.substring(i - 2, i + 1)).orElse("");
    }
}
