package Problem2200;

import java.util.Arrays;

public class Problem2206 {
    public boolean divideArray(int[] nums) {
        int[] count = new int[501];
        Arrays.stream(nums).forEach(i -> count[i]++);
        return Arrays.stream(count).allMatch(i -> i % 2 == 0);
    }
}
