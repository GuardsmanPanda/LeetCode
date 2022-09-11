package Problem1600;

import java.util.stream.IntStream;

public class Problem1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26], last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == 0) {
                first[c] = i + 1;
            }
            last[c] = i + 1;
        }
        return IntStream.range(0, 26).map(i -> last[i] - first[i] - 1).max().orElse(-1);
    }
}
