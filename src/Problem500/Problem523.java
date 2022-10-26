package Problem500;

import java.util.HashSet;

public class Problem523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();
        int sum = 0, last = 0;
        for (int num : nums) {
            sum += num;
            sum %= k;
            if (seen.contains(sum)) {
                return true;
            }
            seen.add(last);
            last = sum;
        }
        return false;
    }
}
