package Problem2000;

import java.util.Arrays;

public class Problem2062 {
    public int countVowelSubstrings(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                int[] cnt = new int[26];
                int missing = 5;
                for (int j = i; j < word.length(); j++) {
                    char x = word.charAt(j);
                    if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                        if (cnt[x - 'a']++ == 0) {
                            missing--;
                        }
                        if (missing == 0) {
                            res++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
