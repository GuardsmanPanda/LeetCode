package Problem1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1403 {
    public List<Integer> minSubsequence(int[] nums) {
        int half = Arrays.stream(nums).sum() / 2;
        Arrays.sort(nums);
        int subSum = 0;
        List<Integer> sub = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            subSum += nums[i];
            sub.add(nums[i]);
            if (subSum > half) {
                break;
            }
        }
        return sub;
    }
}
