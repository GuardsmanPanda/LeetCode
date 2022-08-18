package Problem2000;

import java.util.ArrayList;
import java.util.List;

public class Problem2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lower = 0, count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
            if (num < target) {
                lower++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = lower; i < lower + count; i++) {
            result.add(i);
        }
        return result;
    }
}
