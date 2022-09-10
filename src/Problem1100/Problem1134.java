package Problem1100;

public class Problem1134 {
    public boolean isArmstrong(int n) {
        int sum = 0;
        int num = n;
        int digits = 0;
        while (num > 0) {
            digits++;
            num /= 10;
        }
        num = n;
        while (num > 0) {
            sum += Math.pow(num % 10, digits);
            num /= 10;
        }
        return sum == n;
    }
}
