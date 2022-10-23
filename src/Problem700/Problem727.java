package Problem700;

import java.util.Arrays;

public class Problem727 {
    public String minWindow(String s1, String s2) {
        int[] nextArr = new int[26];
        Arrays.fill(nextArr, -1);
        int[][] next = new int[s1.length()][26];
        for (int i = s1.length() - 1; i >= 0; i--) {
            System.arraycopy(nextArr, 0, next[i], 0, 26);
            nextArr[s1.charAt(i) - 'a'] = i;
        }
        int start = -1, end = s1.length();
        char[] a2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i);
            if (c != s2.charAt(0)) {
                continue;
            }
            int cur = i, idx = 0;
            while (cur != -1 && ++idx < a2.length) {
                cur = next[cur][a2[idx] - 'a'];
            }
            if (cur != -1 && cur - i < end - start) {
                start = i;
                end = cur;
            }
        }
        return start == -1 ? "" : s1.substring(start, end + 1);
    }
}
