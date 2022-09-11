package Problem1800;

import java.util.Arrays;

public class Problem1897 {
    public boolean makeEqual(String[] words) {
        int[] count = new int[128];
        Arrays.stream(words).forEach(s -> s.chars().forEach(c -> count[c]++));
        return Arrays.stream(count).allMatch(c -> c % words.length == 0);
    }
}
