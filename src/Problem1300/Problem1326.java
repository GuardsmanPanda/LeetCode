package Problem1300;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1326 {
    public int minTaps(int n, int[] ranges) {
        if (n == 1) {
            return 1;
        }
        int[][] arr = new int[ranges.length][2];
        for (int i = 0; i < ranges.length; i++) {
            arr[i][0] = Math.max(1, i - ranges[i] + 1);
            arr[i][1] = Math.min(n + 1, i + ranges[i] + 1);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        int[] taps = new int[n + 2];
        Arrays.fill(taps, Integer.MAX_VALUE);
        taps[1] = 0;
        for (int[] a : arr) {
            if (taps[a[0]] == Integer.MAX_VALUE || a[0] == a[1]) {
                continue;
            }
            for (int i = a[0]; i <= a[1]; i++) {
                taps[i] = Math.min(taps[i], taps[a[0]] + 1);
            }
        }
        return taps[n + 1] == Integer.MAX_VALUE ? -1 : taps[n + 1];
    }
}
