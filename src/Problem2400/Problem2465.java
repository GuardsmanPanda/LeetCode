package Problem2400;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2465 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        return (int)IntStream.range(0, nums.length/2).map(i -> nums[i] + nums[nums.length - i - 1]).distinct().count();
    }
}
