package Problem1100;

public class Problem1176 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0, score = 0;
        for (int i = 0; i < calories.length && i < k - 1; i++) {
            score += calories[i];
        }
        for (int i = k - 1; i < calories.length; i++) {
            score += calories[i];
            if (score < lower) {
                points--;
            }
            else if (score > upper) {
                points++;
            }
            score -= calories[i - k + 1];
        }
        return points;
    }
}
