package Problem1700;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem1748 {
    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        Arrays.stream(nums).forEach(i -> count[i]++);
        return IntStream.range(1, 101).filter(i -> count[i] == 1).sum();
    }
}
