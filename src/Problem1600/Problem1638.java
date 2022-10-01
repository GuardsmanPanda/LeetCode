package Problem1600;

public class Problem1638 {
    public int countSubstrings(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    continue;
                }
                int lc = 1, rc = 1;
                while (i - lc >= 0 && j - lc >= 0 && s.charAt(i - lc) == t.charAt(j - lc)) {
                    lc++;
                }
                while (i + rc < s.length() && j + rc < t.length() && s.charAt(i + rc) == t.charAt(j + rc)) {
                    rc++;
                }
                res += lc * rc;
            }
        }
        return res;
    }
}
