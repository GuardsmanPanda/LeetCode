package Problem2100;

import java.util.Arrays;

public class Problem2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int idx = 0, equal = 0;
        for (int num : nums) {
            if (num < pivot) {
                res[idx++] = num;
            }
            if (num == pivot) {
                equal++;
            }
        }
        for (int i = 0; i < equal; i++) {
            res[idx++] = pivot;
        }
        for (int num : nums) {
            if (num > pivot) {
                res[idx++] = num;
            }
        }
        return res;
    }
}
