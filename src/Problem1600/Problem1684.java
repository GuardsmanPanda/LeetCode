package Problem1600;

import java.util.Arrays;

public class Problem1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedChars = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allowedChars[c - 'a'] = true;
        }
        return Arrays.stream(words).mapToInt(word -> {
            for (char c : word.toCharArray()) {
                if (!allowedChars[c - 'a']) {
                    return 0;
                }
            }
            return 1;
        }).sum();
    }
}
