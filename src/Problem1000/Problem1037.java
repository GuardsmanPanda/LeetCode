package Problem1000;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1037 {
    public boolean isBoomerang(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        if (points[0][0] == points[1][0] && points[0][1] == points[1][1] || points[1][0] == points[2][0] && points[1][1] == points[2][1]) {
            return false;
        }
        int dx1 = points[1][0] - points[0][0];
        int dy1 = points[1][1] - points[0][1];
        int dx2 = points[2][0] - points[1][0];
        int dy2 = points[2][1] - points[1][1];
        int gcd1 = gcd(dx1, dy1);
        int gcd2 = gcd(dx2, dy2);
        return dx1 / gcd1 != dx2 / gcd2 || dy1 / gcd1 != dy2 / gcd2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
