package Problem900;

import java.util.Arrays;

public class Problem956 {
    public int tallestBillboard(int[] rods) {
        int[][] highest = new int[rods.length + 1][5005];
        highest[0][2500] = 1;
        for (int i = 1; i <= rods.length; i++) {
            int r = rods[i - 1];
            for (int j = 0; j < highest[i].length; j++) {
                highest[i][j] = highest[i - 1][j];
                if (j + r < highest[i].length && highest[i - 1][j + r] > 0) {
                    highest[i][j] = Math.max(highest[i - 1][j + r], highest[i][j]);
                }
                if (j - r >= 0 && highest[i - 1][j - r] > 0) {
                    highest[i][j] = Math.max(highest[i - 1][j - r] + r, highest[i][j]);
                }
            }
        }
        for (int[] ints : highest) {
            System.out.println(Arrays.toString(ints));
        }
        return highest[rods.length][2500] - 1;
    }
}
