package Problem500;

import java.util.Random;

public class Problem528 {
    private final int[] sampleSum;
    private int totalSum = 0;
    private final Random random = new Random();

    public Problem528(int[] w) {
        sampleSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sampleSum[i] = w[i];
            if (i > 0) {
                sampleSum[i] += sampleSum[i - 1];
            }
            totalSum += w[i];
        }
    }

    public int pickIndex() {
        int n = random.nextInt(totalSum);
        int left = 0, right = sampleSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sampleSum[mid] <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
