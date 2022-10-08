package Problem2400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2420 {
    public List<Integer> goodIndices(int[] nums, int k) {
        boolean[] good = new boolean[nums.length];
        int streak = 0, last = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (++streak > k) {
                good[i] = true;
            }
            if (nums[i] > last) {
                streak = 1;
            }
            System.out.println("i: " + i + ", streak: " + streak + ", last: " + last);

            last = nums[i];
        }
        System.out.println("good: " + Arrays.toString(good));
        List<Integer> res = new ArrayList<>();
        last = Integer.MAX_VALUE;
        streak = 0;
        for (int i = 0; i < nums.length; i++) {
            if (++streak > k && good[i]) {
                res.add(i);
            }
            if (nums[i] > last) {
                streak = 1;
            }
            last = nums[i];
        }
        return res;
    }
}
