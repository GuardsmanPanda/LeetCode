import java.util.Arrays;

public class Problem312 {
    public int maxCoins(int[] nums) {
        int[][] score = new int[nums.length + 2][nums.length + 2];
        int[] newScore = new int[nums.length + 2];
        System.arraycopy(nums, 0, newScore, 1, nums.length);
        newScore[0] = 1;
        newScore[newScore.length - 1] = 1;
        for (int[] ints : score) {
            Arrays.fill(ints, -1);
        }
        return getScore(0, nums.length + 1, newScore, score);
    }

    private int getScore(int left, int right, int[] numbers, int[][] score) {
        if (score[left][right] == -1) {
            if (left+1 >= right) {
                score[left][right] = 0;
            } else {
                for (int i = left + 1; i < right; i++) {
                    int ls = getScore(left, i, numbers, score);
                    int rs = getScore(i, right, numbers, score);
                    int cs = ls + rs + numbers[left] * numbers[right] * numbers[i];
                    score[left][right] = Math.max(score[left][right], cs);
                }
            }
        }
        return score[left][right];
    }
}
