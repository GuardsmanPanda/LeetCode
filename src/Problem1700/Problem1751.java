package Problem1700;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1751 {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int[] nextMaxValue = new int[events.length + 1];
        int[] maxValue = new int[events.length + 1];
        for (int i = 1; i <= k; i++) {
            for (int o = 1; o <= events.length; o++) {
                int[] event = events[o - 1];
                int s = event[0];
                // System.out.println("i: " + i + " o: " + o + " s: " + s + ", event: " + Arrays.toString(event));
                if (events[0][1] >= s) {
                    nextMaxValue[o] = Math.max(nextMaxValue[o - 1], maxValue[0] + event[2]);
                    continue;
                }
                int left = 0, right = o - 1;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;
                    if (events[mid][1] < s) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                nextMaxValue[o] = Math.max(nextMaxValue[o - 1], maxValue[left + 1] + event[2]);
            }
            // System.out.println(Arrays.toString(nextMaxValue));
            int[] temp = maxValue;
            maxValue = nextMaxValue;
            nextMaxValue = temp;
        }
        return maxValue[events.length];
    }
}
