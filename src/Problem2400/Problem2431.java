package Problem2400;

public class Problem2431 {
    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        int[][] maxtaste = new int[maxCoupons + 1][maxAmount + 1];
        for (int i = 0; i < price.length; i++) {
            int p = price[i], t = tastiness[i];
            int pc = p / 2;
            for (int j = maxCoupons; j >= 0; j--) {
                for (int k = maxAmount; k >= pc; k--) {
                    if (k >= p) {
                        maxtaste[j][k] = Math.max(maxtaste[j][k], maxtaste[j][k - p] + t);
                    }
                    if (j > 0) {
                        maxtaste[j][k] = Math.max(maxtaste[j][k], maxtaste[j - 1][k - pc] + t);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= maxCoupons; i++) {
            for (int j = 0; j <= maxAmount; j++) {
                max = Math.max(max, maxtaste[i][j]);
            }
        }
        return max;
    }
}
