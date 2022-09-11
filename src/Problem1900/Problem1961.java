package Problem1900;

public class Problem1961 {
    public boolean isPrefixString(String s, String[] words) {
        int idx = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (idx == s.length() || idx < s.length() && s.charAt(idx++) != word.charAt(i)) {
                    return false;
                }
            }
            if (idx == s.length()) {
                return true;
            }
        }
        return false;
    }
}
