package Problem2400;

public class Problem2443 {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            int k = i, rev = 0;
            while (k > 0) {
                rev = rev * 10 + k % 10;
                k /= 10;
            };
            if (i + rev == num) {
                return true;
            }
        }
        return false;
    }
}
