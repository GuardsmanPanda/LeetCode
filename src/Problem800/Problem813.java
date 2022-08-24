package Problem800;

import java.util.Arrays;

public class Problem813 {
    public double largestSumOfAverages(int[] nums, int k) {
        double[][] score = new double[k--][nums.length + 1];
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            score[0][i + 1] = sum / (i + 1);
        }
        for (int i = 1; i <= k; i++) {
            System.out.println("i = " + i);
            double tmp = 0;
            for (int j = nums.length - 1; j >= i; j--) {
                tmp += nums[j];
                double rightAvg = tmp / (nums.length - j);
                System.out.println("j = " + j + " rightAvg = " + rightAvg);
                if (i == 1) {
                    score[i][j + 1] = rightAvg + score[i - 1][j];
                    continue;
                }
                double tmp2 = 0;
                for (int jj = j - 1; jj >= i - 1; jj--) {
                    tmp2 += nums[jj];
                    double innerAvg = tmp2 / (j - jj);
                    System.out.println("jj = " + jj + " innerAvg = " + innerAvg);
                    score[i][j + 1] = Math.max(score[i][j + 1], rightAvg + innerAvg + score[i - 2][jj]);
                }
            }
            System.out.println(Arrays.toString(score[i]));
        }
        return score[k][nums.length];
    }
}
