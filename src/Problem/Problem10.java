package Problem;

public class Problem10 {
    public boolean isMatch(String s, String p) {
        if (p.charAt(0) == '*') {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length() && p.charAt(i) == '*'; i += 2) {
            dp[0][i + 1] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            for (int j = 0; j < p.length(); j++) {
                char pc = p.charAt(j);
                if (pc == '.' || sc == pc) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pc == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j];
                    char prev = p.charAt(j - 1);
                    if (prev == '.' || prev == sc) {
                        dp[i + 1][j + 1] |= dp[i][j + 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
