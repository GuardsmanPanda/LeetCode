package Problem300;

public class Problem343 {
    public int integerBreak(int n) {
        if (n < 4) return n-1;
        int prod = 1;
        while (n > 4) {
            prod *= 3;
            n -= 3;
        }
        return prod * n;
    }
}
