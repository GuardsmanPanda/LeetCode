package Problem2300;

import java.util.Arrays;

public class Problem2317 {
    public int maximumXOR(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a | b);
    }
}
