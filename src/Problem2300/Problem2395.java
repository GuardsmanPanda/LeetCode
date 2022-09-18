package Problem2300;

import java.util.HashSet;

public class Problem2395 {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> found = new HashSet<>();
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            val += nums[i];
            if (!found.add(val)) {
                return true;
            }
            found.add(val);
            val -= nums[i - 1];
        }
        return false;
    }
}
