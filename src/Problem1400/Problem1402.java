package Problem1400;

import java.util.Arrays;

public class Problem1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int prefix = 0, cur = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            int val = satisfaction[i];
            prefix += val;
            if (prefix < 0) {
                break;
            }
            cur += prefix;
        }
        return cur;
    }
}
