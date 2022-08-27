package Problem2200;

import java.util.Arrays;

public class Problem2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] sc = new int[26];
        int[] tc = new int[26];
        for (char c : s.toCharArray()) {
            sc[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            tc[c - 'a']++;
        }
        int min = s.length();
        for (int i = 0; i < tc.length; i++) {
            if (tc[i] != 0) {
                min = Math.min(min, sc[i]/tc[i]);
            }
        }
        return min;
    }
}
