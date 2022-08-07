import java.util.Arrays;

public class Problem2330 {
    public boolean makePalindrome(String s) {
        char[] chars = s.toCharArray();
        int difF = 0;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                difF++;
            }
        }
        return difF <= 2;
    }
}
