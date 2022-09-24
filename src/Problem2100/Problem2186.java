package Problem2100;

import java.util.Arrays;

public class Problem2186 {
    public int minSteps(String s, String t) {
        int[] count = new int[128];
        s.chars().forEach(c -> count[c]++);
        t.chars().forEach(c -> count[c]--);
        return Arrays.stream(count).map(Math::abs).sum();
    }
}
