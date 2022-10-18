package Problem1500;

import java.util.Arrays;

public class Problem1531 {
    public int getLengthOfOptimalCompression(String s, int k) {
        int[][] rl = new int[s.length() + 1][k + 1];
        char[] a = s.toCharArray();
        for (int i = 1; i < rl.length; i++) {
            Arrays.fill(rl[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0) { // delete the current char
                    rl[i + 1][j] = Math.min(rl[i + 1][j], rl[i][j - 1]);
                }
                int diff = 0, same = 0, idx = i + 1;
                while (--idx >= 0) {
                    same += a[idx] == a[i] ? 1 : 0;
                    diff += a[idx] != a[i] ? 1 : 0;
                    if (diff + j > k) {
                        break;
                    }
                    int cost = 1 + (same > 1 ? 1 : 0) + (same > 9 ? 1 : 0) + (same > 99 ? 1 : 0);
                    rl[i + 1][j + diff] = Math.min(rl[i + 1][j + diff], rl[idx][j] + cost);
                }
            }
        }
        return rl[s.length()][k];
    }
}
