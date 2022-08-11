package Problem1300;

import java.util.Arrays;

public class Problem1335 {
    // [2, 4, 2, 1];
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }
        int[] totalDiff = new int[jobDifficulty.length];
        totalDiff[jobDifficulty.length - 1] = jobDifficulty[jobDifficulty.length - 1];

        for (int i = totalDiff.length - 2; i >= 0; i--) {
            totalDiff[i] = Math.max(totalDiff[i + 1], jobDifficulty[i]);
        }
        for (int i = d - 1; i > 0; i--) {
            System.out.println(Arrays.toString(totalDiff));
            for (int k = i - 1; k < jobDifficulty.length - 1; k++) {
                int min = Integer.MAX_VALUE;
                int max = jobDifficulty[k];
                for (int j = k; j < jobDifficulty.length - d + i - 1; j++) {
                    max = Math.max(max, jobDifficulty[j]);
                    min = Math.min(min, totalDiff[j + 1] + max);
                }
                totalDiff[k] = min;
            }
        }
        return totalDiff[0];
    }
}
