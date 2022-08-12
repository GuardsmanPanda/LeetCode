package Problem1200;

public class Problem1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1, high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            long count = getUglyCount(mid, a, b, c);
            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private long getUglyCount(int number, long a, long b, long c) {
        long count = number / a + number / b + number / c;
        long ab = a*b / gcd(a, b), ac = a*c / gcd(a, c), bc = b*c / gcd(b, c);
        count -= number / ab + number / ac + number / bc;
        long abc = ab*c / gcd(ab, c);
        count += number / abc;
        return count;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
