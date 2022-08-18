package Problem2300;

import java.util.Arrays;

public class Problem2357 {
    public int minimumOperations(int[] nums) {
        return (int)Arrays.stream(nums).filter(i -> i != 0).distinct().count();
    }
}
