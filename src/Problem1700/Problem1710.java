package Problem1700;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> -a[1]));
        int res = 0;
        for (int[] bt : boxTypes) {
            int min = Math.min(truckSize, bt[0]);
            res += min * bt[1];
            truckSize -= min;
        }
        return res;
    }
}
