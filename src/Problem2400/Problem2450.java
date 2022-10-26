package Problem2400;

public class Problem2450 {
    public int countDistinctStrings(String s, int k) {
        int mod = 1000000007;
        int res = 1;
        for (int i = s.length() - k; i >= 0; i--) {
            res *= 2;
            res %= mod;
        }
        return res;
    }
}
