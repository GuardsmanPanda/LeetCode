package Problem2100;

public class Problem2169 {
    public int countOperations(int num1, int num2) {
        int res = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                res += num1 / num2;
                num1 %= num2;
            } else {
                res += num2 / num1;
                num2 %= num1;
            }
        }
        return res;
    }
}
