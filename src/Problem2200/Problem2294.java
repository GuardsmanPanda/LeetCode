package Problem2200;

import java.util.Arrays;

public class Problem2294 {
    public int partitionArray(int[] nums, int k) {
        int[] count = new int[100_001];
        int res = 0;
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                i += k;
                res++;
            }
        }
        return res;
    }
}
