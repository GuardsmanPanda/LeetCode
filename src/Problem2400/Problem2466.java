package Problem2400;

public class Problem2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] count = new long[high + 1];
        long mod = 1000000007, result = 0;
        count[0] = 1;
        for (int i = 1; i <= high; i++) {
            count[i] += i >= zero ? count[i - zero] : 0;
            count[i] += i >= one ? count[i - one] : 0;
            count[i] %= mod;
            result += i >= low ? count[i] : 0;
        }
        return (int)(result % mod);
    }
}
