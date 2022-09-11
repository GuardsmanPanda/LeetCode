package Problem1900;

import java.util.stream.IntStream;

public class Problem1903 {
    public String largestOddNumber(String num) {
        return IntStream.range(0, num.length())
                .filter(i -> (num.charAt(i) - '0') % 2 == 1).max()
                .stream().mapToObj(i -> num.substring(0, i + 1))
                .findFirst().orElse("");
    }
}
