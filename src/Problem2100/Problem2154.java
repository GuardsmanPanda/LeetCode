package Problem2100;

import java.util.Arrays;

public class Problem2154 {
    public int findFinalValue(int[] nums, int original) {
        boolean[] found = new boolean[1001];
        Arrays.stream(nums).forEach(i -> found[i] = true);
        while (original <= 1000 && found[original]) {
            original *= 2;
        }
        return original;
    }
}
