package Problem1300;

public class Problem1388 {
    public int maxSizeSlices(int[] slices) {
        int steps = slices.length / 3;
        int[][] maxScore = new int[steps + 1][slices.length + 1];
        int[][] maxScore2 = new int[steps + 1][slices.length + 1];
        maxScore[1][1] = slices[0];
        for (int i = 1; i <= steps; i++) {
            for (int j = 1; j < slices.length; j++) {
                maxScore[i][j + 1] = Math.max(maxScore[i][j], maxScore[i - 1][j - 1] + slices[j]);
                maxScore2[i][j + 1] = Math.max(maxScore2[i][j], maxScore2[i - 1][j - 1] + slices[j]);
            }
        }
        return Math.max(maxScore[steps][slices.length - 1], maxScore2[steps][slices.length]);
    }
}
