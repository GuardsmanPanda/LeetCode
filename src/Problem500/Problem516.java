package Problem500;

public class Problem516 {
    public int longestPalindromeSubseq(String s) {
        int[][] length = new int[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            length[i][i] = 1;
        }
        int max = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    length[i][j] = length[i + 1][j - 1] + 2;
                } else {
                    length[i][j] = Math.max(length[i + 1][j], length[i][j - 1]);
                }
                max = Math.max(max, length[i][j]);
            }
        }
        return max;
    }
}
