package Problem1100;

import java.util.Arrays;

public class Problem1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        return Arrays.stream(nums).filter(i -> i == target).count() > nums.length / 2;
    }
}
