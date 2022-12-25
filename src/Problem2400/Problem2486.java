package Problem2400;

public class Problem2486 {
    public int appendCharacters(String s, String t) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < s.length() && idx2 < t.length()) {
            if (s.charAt(idx1++) == t.charAt(idx2)) {
                idx2++;
            }
        }
        return t.length() - idx2;
    }
}
