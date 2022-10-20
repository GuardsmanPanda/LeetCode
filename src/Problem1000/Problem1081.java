package Problem1000;

import java.util.ArrayDeque;

public class Problem1081 {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[26];
        for (char c : arr) {
            count[c - 'a']--;
            if (used[c - 'a']) {
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.setLength(sb.length() - 1);
            }
            used[c - 'a'] = true;
            sb.append(c);
        }
        return sb.toString();
    }
}
