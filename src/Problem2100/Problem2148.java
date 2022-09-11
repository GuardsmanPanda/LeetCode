package Problem2100;

import java.util.Arrays;

public class Problem2148 {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int m1 = min, m2 = max;
        return (int)Arrays.stream(nums).filter(num -> num > m1 && num < m2).count();
    }
}
