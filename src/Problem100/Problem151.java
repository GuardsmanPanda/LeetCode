package Problem100;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem151 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        return IntStream.range(0, words.length)
                .mapToObj(i -> words[words.length - i - 1])
                .filter(word -> !word.isEmpty())
                .collect(Collectors.joining(" "));
    }
}
