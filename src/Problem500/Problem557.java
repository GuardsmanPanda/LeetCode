package Problem500;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem557 {
    public String reverseWords(String s) {
        return Stream.of(s.split(" "))
                .map(word -> new StringBuilder().append(word).reverse())
                .collect(Collectors.joining(" "));
    }
}
