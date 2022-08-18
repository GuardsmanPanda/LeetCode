package Problem1400;

import java.util.Arrays;

public class Problem1449 {
    public String largestNumber(int[] cost, int target) {
        int[] use = new int[target + 1];
        int[] cnt = new int[target + 1];
        cnt[0] = 1;
        for (int i = 1; i < cnt.length; i++) {
            for (int k = 0; k < cost.length; k++) {
                int prev = i - cost[k];
                if (prev < 0 || cnt[prev] == 0) {
                    continue;
                }
                if (cnt[i] <= cnt[prev] + 1) {
                    cnt[i] = cnt[prev] + 1;
                    use[i] = k;
                }
            }
        }
        // System.out.println(Arrays.toString(cnt));
        // System.out.println(Arrays.toString(use));
        if (cnt[target] == 0) {
            return "0";
        }
        int idx = target;
        StringBuilder sb = new StringBuilder();
        while (idx > 0) {
            int i = use[idx];
            idx -= cost[i];
            sb.append(i + 1);
        }
        return sb.toString();
    }
}
