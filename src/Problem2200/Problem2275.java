package Problem2200;

import java.util.Arrays;

public class Problem2275 {
    public int largestCombination(int[] candidates) {
        int[] count = new int[30];
        for (int candidate : candidates) {
            for (int i = 0; i < 30; i++) {
                if ((candidate & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }
        return Arrays.stream(count).max().orElse(0);
    }
}
