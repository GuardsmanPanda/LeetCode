package Problem2400;

import java.util.Arrays;

public class Problem2455 {
    public int averageValue(int[] nums) {
        return (int)Arrays.stream(nums)
                .filter(n -> n % 2 == 0 && n % 3 == 0)
                .average().orElse(0);
    }
}
