package Problem1200;

import java.util.Arrays;

public class Problem1262 {
    public int maxSumDivThree(int[] nums) {
        int[] remain = new int[3];
        for (int num : nums) {
            int a = remain[0] + num;
            int b = remain[1] + num;
            int c = remain[2] + num;
            remain[b % 3] = Math.max(remain[b % 3], b);
            remain[c % 3] = Math.max(remain[c % 3], c);
            remain[a % 3] = Math.max(remain[a % 3], a);
            System.out.println("num: " + num + ", remain: " + Arrays.toString(remain));
        }
        return remain[0];
    }
}
