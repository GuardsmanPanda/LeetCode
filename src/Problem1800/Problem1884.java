package Problem1800;

import java.util.Arrays;

public class Problem1884 {
    public int twoEggDrop(int n) {
        int[] val = new int[n + 1];
        Arrays.fill(val, Integer.MAX_VALUE);
        return getRes(2, n, val);
    }

    private int getRes(int eggs, int height, int[] twoVal) {
        if (eggs == 1 || height < 3) {
            return height;
        }
        if (twoVal[height] == Integer.MAX_VALUE) {
            for (int i = 1; i <= height; i++) {
                int tmp = Math.max(getRes(eggs - 1, i - 1, twoVal), getRes(eggs, height - i, twoVal));
                twoVal[height] = Math.min(twoVal[height], tmp);
            }
            twoVal[height]++;
        }
        return twoVal[height];
    }
}
