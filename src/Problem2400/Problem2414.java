package Problem2400;

public class Problem2414 {
    public int longestContinuousSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length();) {
            int len = 1;
            while (i + len < s.length() && s.charAt(i + len - 1) + 1 == s.charAt(i + len)) {
                len++;
            }
            max = Math.max(max, len);
            i += len;
        }
        return max;
    }
}
