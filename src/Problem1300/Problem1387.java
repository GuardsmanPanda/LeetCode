package Problem1300;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1387 {
    public int getKth(int lo, int hi, int k) {
        int[][] res = new int[hi - lo + 1][2];
        for (int i = lo; i <= hi; i++) {
            int x = i, count = 0;
            while (x != 1) {
                if (x % 2 == 0) {
                    x /= 2;
                } else {
                    x = 3 * x + 1;
                }
                count++;
            }
            res[i - lo][0] = i;
            res[i - lo][1] = count;
        }
        Arrays.sort(res, Comparator.comparingInt(a -> a[1]));
        return res[k - 1][0];
    }
}
