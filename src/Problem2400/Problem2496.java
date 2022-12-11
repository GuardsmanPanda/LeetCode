package Problem2400;

import java.util.Arrays;

public class Problem2496 {
    public int maximumValue(String[] strs) {
        return Arrays.stream(strs).mapToInt(s -> s.matches("\\d+") ? Integer.parseInt(s) : s.length()).max().orElse(0);
    }
}
