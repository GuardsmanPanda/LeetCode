package Problem1400;

public class Problem1422 {
    public int maxScore(String s) {
        int score = s.chars().map(i -> i - '0').sum();
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += s.charAt(i) == '0' ? 1 : -1;
            max = Math.max(max, score);
        }
        return max;
    }
}
