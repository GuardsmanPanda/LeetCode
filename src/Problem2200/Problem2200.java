package Problem2200;

import java.util.ArrayList;
import java.util.List;

public class Problem2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0, idx = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                idx = Math.max(idx, i - k);
                while (idx < nums.length && idx <= i + k) {
                    res.add(idx);
                    idx++;
                }
            }
        }
        return res;
    }
}
