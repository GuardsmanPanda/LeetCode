import java.util.Arrays;

public class Problem1220 {
    public int countVowelPermutation(int n) {
        long[][] ways = new long[n][5];
        ways[0][0] = 1;
        ways[0][1] = 1;
        ways[0][2] = 1;
        ways[0][3] = 1;
        ways[0][4] = 1;
        for (int i = 1; i < n; i++) {
            ways[i][0] = ways[i - 1][1] + ways[i - 1][2] + ways[i - 1][4];
            ways[i][1] = ways[i - 1][0] + ways[i - 1][2];
            ways[i][2] = ways[i - 1][1] + ways[i - 1][3];
            ways[i][3] = ways[i - 1][2];
            ways[i][4] = ways[i - 1][2] + ways[i - 1][3];
            ways[i][0] %= 1000000007;
            ways[i][1] %= 1000000007;
            ways[i][2] %= 1000000007;
            ways[i][3] %= 1000000007;
            ways[i][4] %= 1000000007;
        }
        return (int)(Arrays.stream(ways[n - 1]).sum() % 1000000007);
    }
}
