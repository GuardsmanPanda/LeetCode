package Problem800;

public class Problem858 {
    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        p /= g;
        q /= g;
        if (p % 2 == 0) {
            return 2;
        }
        return q % 2 == 1 ? 1 : 0;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
