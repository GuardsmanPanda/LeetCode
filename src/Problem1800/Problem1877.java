package Problem1800;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        return IntStream.range(0, nums.length/2).map(i -> nums[i] + nums[nums.length-i-1]).max().orElse(0);
    }
}
