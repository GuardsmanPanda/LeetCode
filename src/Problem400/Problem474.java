package Problem400;

public class Problem474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] total = new int[m+1][n+1];
        for (String str : strs) {
            int ones = 0, zeros = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    total[i][j] = Math.max(total[i][j], total[i-zeros][j-ones]+1);
                }
            }
        }
        return total[m][n];
    }
}
