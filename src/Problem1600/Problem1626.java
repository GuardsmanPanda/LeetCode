package Problem1600;

import java.util.Arrays;

public class Problem1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[] maxScoreForAge = new int[1001];
        int[][] scoreAge = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            scoreAge[i][0] = scores[i];
            scoreAge[i][1] = ages[i];
        }
        Arrays.sort(scoreAge, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] sa : scoreAge) {
            int max = maxScoreForAge[sa[1]];
            for (int i = 0; i < sa[1]; i++) {
                max = Math.max(max, maxScoreForAge[i]);
            }
            maxScoreForAge[sa[1]] = max + sa[0];
        }
        return Arrays.stream(maxScoreForAge).max().getAsInt();
    }
}
