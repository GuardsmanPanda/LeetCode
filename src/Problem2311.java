public class Problem2311 {
    public int longestSubsequence(String s, int k) {
        char[] chars = s.toCharArray();
        int length = 0;
        long current = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                int tmp = chars.length - i - 1;
                if (tmp < 32 && current + Math.pow(2, tmp) <= k) {
                    current += Math.pow(2, tmp);
                    length++;
                }
            } else {
                length++;
            }
        }
        return length;
    }
}
