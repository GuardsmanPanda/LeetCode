package Problem1700;

public class Problem1796 {
    public int secondHighest(String s) {
        boolean[] found = new boolean[10];
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                found[c - '0'] = true;
            }
        }
        boolean foundFirst = false;
        for (int i = found.length - 1; i >= 0; i--) {
            if (found[i]) {
                if (foundFirst) {
                    return i;
                }
                foundFirst = true;
            }
        }
        return -1;
    }
}
