package Problem1100;

import java.util.Arrays;

public class Problem1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsCount = new int[words.length];
        int[] res = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            wordsCount[i] = f(words[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            int count = f(queries[i]);
            for (int k : wordsCount) {
                res[i] += count < k ? 1 : 0;
            }
        }
        return res;
    }

    private int f(String s) {
        int[] count = new int[26];
        s.chars().forEach(c -> count[c - 'a']++);
        return Arrays.stream(count).filter(c -> c > 0).findFirst().orElse(0);
    }
}
