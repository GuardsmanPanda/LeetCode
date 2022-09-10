package Problem2200;

import java.util.Arrays;

public class Problem2278 {
    public int percentageLetter(String s, char letter) {
        long count = s.chars().filter(c -> c == letter).count();
        return (int)(count * 100 / s.length());
    }
}
