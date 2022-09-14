package Problem1500;

public class Problem1544 {
    public String makeGood(String s) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < s.length() - 1; i++) {
                if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    changed = true;
                    break;
                }
            }
        }
        return s;
    }
}
