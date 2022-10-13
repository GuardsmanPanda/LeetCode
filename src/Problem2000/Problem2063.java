package Problem2000;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem2063 {
    public long countVowels(String word) {
        return IntStream.range(0, word.length())
                .filter(i -> "aeiou".indexOf(word.charAt(i)) != -1)
                .mapToLong(i -> (i + 1L) * (word.length() - i))
                .sum();
    }
}
