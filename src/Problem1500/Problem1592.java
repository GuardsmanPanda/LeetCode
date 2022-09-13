package Problem1500;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem1592 {
    public String reorderSpaces(String text) {
        int sc = (int)text.chars().filter(c -> c == ' ').count();
        String[] words = text.trim().split("\\s+");
        if (words.length == 1) {
            return words[0] + " ".repeat(sc);
        }
        return Arrays.stream(words).collect(Collectors.joining(" ".repeat(sc / (words.length - 1)), "", " ".repeat(sc % (words.length - 1))));
    }
}
