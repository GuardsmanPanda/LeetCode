package Problem400;

public class Problem408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx = 0, wdx = 0;
        while (idx < abbr.length() && wdx < word.length()) {
            char c = abbr.charAt(idx);
            if (c == '0') {
                return false;
            }
            int cnt = 0;
            while(idx < abbr.length() && Character.isDigit(abbr.charAt(idx))) {
                cnt = cnt * 10 + abbr.charAt(idx) - '0';
                idx++;
            }
            if (cnt > 0) {
                wdx += cnt;
            } else if (abbr.charAt(idx++) != word.charAt(wdx++)) {
                return false;
            }
        }
        return idx == abbr.length() && wdx == word.length();
    }
}
