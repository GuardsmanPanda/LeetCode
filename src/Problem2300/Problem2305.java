package Problem2300;

import java.util.Arrays;

public class Problem2305 {
    public int distributeCookies(int[] cookies, int k) {
        findBest(cookies, 0, new int[k]);
        return best;
    }

    private int best = Integer.MAX_VALUE;
    private void findBest(int[] cookies, int idx, int[] values) {
        if (idx == cookies.length) {
            best = Arrays.stream(values).max().orElse(0);
            return;
        }
        for (int i = 0; i < values.length; i++) {
            values[i] += cookies[idx];
            if (values[i] < best) {
               findBest(cookies, idx + 1, values);
            }
            values[i] -= cookies[idx];
            if (values[i] == 0) {
                break;
            }
        }
    }
}
