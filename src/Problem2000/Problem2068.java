package Problem2000;

import java.util.Arrays;

public class Problem2068 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] count = new int[128];
        word1.chars().forEach(c -> count[c]++);
        word2.chars().forEach(c -> count[c]--);
        return Arrays.stream(count).allMatch(c -> Math.abs(c) <= 3);
    }
}
