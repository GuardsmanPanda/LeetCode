package Problem1300;

public class Problem1332 {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return 2;
            }
        }
        return 1;
    }
}
