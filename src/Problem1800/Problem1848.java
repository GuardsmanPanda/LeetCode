package Problem1800;

import java.util.stream.IntStream;

public class Problem1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        return IntStream.range(0, nums.length)
                .filter(i -> nums[i] == target)
                .map(i -> Math.abs(i - start))
                .min().orElse(-1);
    }
}
