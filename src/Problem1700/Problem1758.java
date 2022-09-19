package Problem1700;

public class Problem1758 {
    public int minOperations(String s) {
        int fails = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0 && s.charAt(i) == '1') {
                fails++;
            } else if (i % 2 == 1 && s.charAt(i) == '0') {
                fails++;
            }
        }
        return Math.min(fails, s.length() - fails);
    }
}
