package Problem1000;

public class Problem1056 {
    public boolean confusingNumber(int n) {
        int a = n, b = 0;
        while (a > 0) {
            int d = a % 10;
            if (d == 2 || d == 3 || d == 4 || d == 5 || d == 7) {
                return false;
            }
            b = b * 10 + switch (d) {
                case 0 -> 0;
                case 1 -> 1;
                case 6 -> 9;
                case 8 -> 8;
                case 9 -> 6;
                default -> throw new IllegalStateException("Unexpected value: " + d);
            };
            a /= 10;
        }
        return b != n;
    }
}
