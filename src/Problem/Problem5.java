package Problem;

public class Problem5 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int startIndex = 0;
        int stopIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i-1, k=i+1; j >= 0 && k < chars.length; j--, k++) {
                if (chars[j] == chars[k]) {
                    if (k-j > max) {
                        max = k-j; startIndex = j; stopIndex = k;
                    }
                }
                else break;
            }
        }
        for (int i = 0; i < chars.length-1; i++) {
            for (int j = i, k=i+1; j >= 0 && k < chars.length; j--, k++) {
                if (chars[j] == chars[k]) {
                    if (k-j > max) {
                        max = k-j; startIndex = j; stopIndex = k;
                    }
                }
                else break;
            }
        }
        return s.substring(startIndex, stopIndex+1);
    }
}
