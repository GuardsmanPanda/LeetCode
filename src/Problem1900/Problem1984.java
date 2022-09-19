package Problem1900;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        return IntStream.range(k - 1, nums.length).map(i -> nums[i] - nums[i - k + 1]).min().orElse(-1);
    }
}
