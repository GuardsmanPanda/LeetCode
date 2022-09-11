package Problem1800;

import java.util.stream.IntStream;

public class Problem1876 {
    public int countGoodSubstrings(String s) {
        return IntStream.range(2, s.length()).filter(i -> s.charAt(i) != s.charAt(i - 1) && s.charAt(i) != s.charAt(i - 2) && s.charAt(i - 1) != s.charAt(i - 2)).map(i -> 1).sum();
    }
}
