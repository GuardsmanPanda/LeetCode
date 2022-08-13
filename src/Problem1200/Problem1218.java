package Problem1200;

import java.util.Arrays;

public class Problem1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int[] subLength = new int[20005];
        for (int i : arr) {
            int target = i - difference + 10000;
            subLength[i + 10000] = Math.max(subLength[i + 10000], (target < 0 || target > 20000 ? 0 : subLength[target]) + 1);
        }
        return Arrays.stream(subLength).max().orElse(-1);
    }
}
