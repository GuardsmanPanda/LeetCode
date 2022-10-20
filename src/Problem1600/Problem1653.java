package Problem1600;

import java.util.Arrays;

public class Problem1653 {
    public int minimumDeletions(String s) {
        int[] deleted = new int[s.length()];
        int countA = 0, countB = 0;
        for (int i = 0; i < s.length(); i++) {
            countB += s.charAt(i) == 'b' ? 1 : 0;
            deleted[i] = countB;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            countA += s.charAt(i) == 'a' ? 1 : 0;
            deleted[i] += countA;
        }
        return Arrays.stream(deleted).min().orElse(1) - 1;
    }
}
