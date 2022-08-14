package Problem1400;

import java.util.Arrays;

public class Problem1406 {
    public String stoneGameIII(int[] stoneValue) {
        int[] a = new int[stoneValue.length + 3];
        a[3] = stoneValue[stoneValue.length - 1];
        for (int i = stoneValue.length - 2, idx = 4; i >= 0; i--, idx++) {
            int s = stoneValue[i];
            a[idx] = -a[idx - 1] + s;
            a[idx] = Math.max(a[idx], -a[idx - 2] + s + stoneValue[i + 1]);
            a[idx] = Math.max(a[idx], -a[idx - 3] + s + stoneValue[i + 1] + (i < stoneValue.length -2 ? stoneValue[i + 2] : 0));
        }
        return a[a.length-1] == 0 ? "Tie" : a[a.length-1] > 0 ? "Alice" : "Bob";
    }
}
