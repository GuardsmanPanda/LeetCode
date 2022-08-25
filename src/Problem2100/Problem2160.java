package Problem2100;

import java.util.Arrays;

public class Problem2160 {
    public int minimumSum(int num) {
        int[] vals = new int[4];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(vals);
        return vals[0] * 10 + vals[1] * 10 + vals[2] + vals[3];
    }
}
