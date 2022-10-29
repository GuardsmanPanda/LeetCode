package Problem2300;

import java.util.Arrays;

public class Problem2342 {
    public int maximumSum(int[] nums) {
        int[] sum = new int[82];
        Arrays.fill(sum, Integer.MIN_VALUE);
        int max = -1;
        for (int num : nums) {
            int xx = num;
            int d = 0;
            while (xx > 0) {
                d += xx % 10;
                xx /= 10;
            }
            max = Math.max(max, sum[d] + num);
            sum[d] = Math.max(sum[d], num);
        }
        return max;
    }
}
