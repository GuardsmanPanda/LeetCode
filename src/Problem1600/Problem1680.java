package Problem1600;

public class Problem1680 {
    public int concatenatedBinary(int n) {
        long res = 0, len = 1, shift = 1;
        for (int i = 1; i <= n; i++) {
            if (i > len) {
                len <<= 1;
                shift++;
                len++;
            }
            res <<= shift;
            res |= i;
            res %= 1_000_000_007;
        }
        return (int)res;
    }
}
