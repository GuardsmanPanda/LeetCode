package Problem200;

public class Problem279 {
    public int numSquares(int n) {
        if (isSQ(n)) return 1;
        while ((n % 4) == 0)
            n >>= 2;
        if (n % 8 == 7) return 4;
        for (int i = 1; i <= Math.sqrt(n); i++)
            if (isSQ(n - i * i)) return 2;
        return 3;
    }

    private boolean isSQ(int a) {
        int b = (int) Math.sqrt(a);
        return b * b == a;
    }
}
