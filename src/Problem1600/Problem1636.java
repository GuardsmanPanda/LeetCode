package Problem1600;

import java.util.Arrays;

public class Problem1636 {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        Arrays.stream(nums).forEach(i -> count[i + 100]++);
        return Arrays.stream(nums).boxed()
                .sorted((a, b) -> count[a + 100] != count[b + 100] ? count[a + 100] - count[b + 100] : b - a)
                .mapToInt(i -> i).toArray();
    }
}
