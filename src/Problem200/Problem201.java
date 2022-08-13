package Problem200;

public class Problem201 {
    public int rangeBitwiseAnd(int m, int n) {
        int steps = 0;
        while (m != n) {
            n >>= 1;
            m >>= 1;
            steps++;
        }
        return m <<= steps;
    }
}
