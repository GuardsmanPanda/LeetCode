package Problem2200;

import java.util.Arrays;

public class Problem2268 {
    private static final int[] presses = {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3};

    public int minimumKeypresses(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        int res = 0;
        for (int i = count.length - 1, idx = 0; i >= 0; i--) {
            res += count[i] * presses[idx++];
        }
        return res;
    }
}
