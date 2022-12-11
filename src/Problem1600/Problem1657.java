package Problem1600;

import java.util.Arrays;

public class Problem1657 {
    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26], count2 = new int[26];
        word1.chars().forEach(c -> count1[c - 'a']++);
        word2.chars().forEach(c -> count2[c - 'a']++);
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i] && (count1[i] == 0 || count2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }
}
