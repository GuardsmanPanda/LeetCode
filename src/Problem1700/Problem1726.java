package Problem1700;

import java.util.HashMap;

public class Problem1726 {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> found = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int res = nums[i] * nums[j];
                count += found.compute(res, (k, v) -> v == null ? 0 : v + 1) * 8;
            }
        }
        return count;
    }
}
