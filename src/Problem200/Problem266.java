package Problem200;

import java.util.Arrays;

public class Problem266 {
    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[128];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        return Arrays.stream(cnt).filter(i -> i % 2 == 1).count() <= 1;
    }
}
