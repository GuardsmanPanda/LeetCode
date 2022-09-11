package Problem1100;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem1133 {
    public int largestUniqueNumber(int[] nums) {
        int[] count = new int[1001];
        Arrays.stream(nums).forEach(i -> count[i]++);
        return IntStream.range(0, 1001).filter(i -> count[i] == 1).max().orElse(-1);
    }
}
