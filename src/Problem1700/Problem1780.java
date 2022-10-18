package Problem1700;

public class Problem1780 {
    public boolean checkPowersOfThree(int n) {
        int val = 1;
        while (val < n) {
            val *= 3;
        }
        while (val > 0 && n > 0) {
            if (val <= n) {
                n -= val;
            }
            val /= 3;
        }
        return n == 0;
    }
}
