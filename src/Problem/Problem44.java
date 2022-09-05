package Problem;

public class Problem44 {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        for(int j = 0; j < p.length() && p.charAt(j) == '*'; j++)
            match[0][j+1] = true;
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            for (int j = 0; j < p.length(); j++) {
                char pChar = p.charAt(j);
                if (pChar == '*') match[i+1][j+1] = match[i+1][j] || match[i][j+1];
                else match[i+1][j+1] = (sChar == pChar || pChar == '?') && match[i][j];
            }
        }
        return match[s.length()][p.length()];
    }
}
