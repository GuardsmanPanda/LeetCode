package Problem2200;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2229 {
    public boolean isConsecutive(int[] nums) {
        Arrays.sort(nums);
        return IntStream.range(1, nums.length).allMatch(i -> nums[i] - nums[i - 1] == 1);
    }
}
