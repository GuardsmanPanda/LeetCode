package Problem700;

public class Problem712 {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] sum = new int[s1.length()+1][s2.length()+1];
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            sum[i + 1][0] = sum[i][0] + a[i];
        }
        for (int i = 0; i < s2.length(); i++) {
            sum[0][i + 1] = sum[0][i] + b[i];
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (a[i - 1] == b[j - 1]) {
                    sum[i][j] = sum[i - 1][j - 1];
                } else {
                    sum[i][j] = Math.min(sum[i - 1][j] + a[i - 1], sum[i][j - 1] + b[j - 1]);
                }
            }
        }
        return sum[s1.length()][s2.length()];
    }
}
