package Problem1000;

import java.util.Arrays;

public class Problem1085 {
    public int sumOfDigits(int[] nums) {
        int min = Arrays.stream(nums).min().orElse(0);
        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }
        return sum % 2 == 0 ? 1 : 0;
    }
}
