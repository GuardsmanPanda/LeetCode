package Problem2400;

public class Problem2457 {
    public long makeIntegerBeautiful(long n, int target) {
        long result = 0, mul = 1;
        while (digitSum(n) > target) {
            result += mul * (10 - n % 10);
            mul *= 10;
            n /= 10;
            n++;
        }
        return result;
    }

    private int digitSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
