package Problem2400;

import java.util.Arrays;

public class Problem2441 {
    public int findMaxK(int[] nums) {
        boolean[] found = new boolean[1001];
        Arrays.stream(nums).filter(i -> i < 0).forEach(i -> found[-i] = true);
        return Arrays.stream(nums).filter(i -> i > 0).filter(i -> found[i]).max().orElse(-1);
    }
}
