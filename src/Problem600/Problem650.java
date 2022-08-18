package Problem600;

import java.util.Arrays;

public class Problem650 {
    public int minSteps(int n) {
        int[] steps = new int[n + 1];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[1] = 0;
        for (int i = 1; i < steps.length; i++) {
            for(int k = i+i, step = 2; k < steps.length; k += i, step++) {
                steps[k] = Math.min(steps[k], steps[i] + step);
            }
        }
        return steps[n];
    }
}
