package Problem1400;

import java.util.stream.IntStream;

public class Problem1423 {
    public int maxScore(int[] cardPoints, int k) {
        int[] rightScore = new int[k + 1];
        int[] leftScore = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rightScore[k - i - 1] = rightScore[k - i] + cardPoints[cardPoints.length - 1 - i];
            leftScore[i + 1] = leftScore[i] + cardPoints[i];
        }
        return IntStream.range(0, k + 1)
                .map(i -> rightScore[i] + leftScore[i])
                .max().orElse(0);
    }
}
