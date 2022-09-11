package Problem1700;

import java.util.Arrays;

public class Problem1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            count[getSum(i)]++;
        }
        return Arrays.stream(count).max().getAsInt();
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
