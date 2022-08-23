package Problem2300;

public class Problem2309 {
    public String greatestLetter(String s) {
        boolean[] found = new boolean[128];
        for (char c : s.toCharArray()) {
            found[c] = true;
        }
        for (char c = 'Z', lc = 'z'; c >= 'A'; c--, lc--) {
            if (found[c] && found[lc]) {
                return String.valueOf(c);
            }
        }
        return "";
    }
}
