package Problem2100;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] plants = new int[plantTime.length][2];
        for (int i = 0; i < plantTime.length; i++) {
            plants[i][0] = plantTime[i];
            plants[i][1] = growTime[i];
        }
        Arrays.sort(plants, Comparator.comparingInt(a -> -a[1]));
        int cur = 0, max = 0;
        for (int[] plant : plants) {
            cur += plant[0];
            max = Math.max(max, cur + plant[1]);
        }
        return max;
    }
}
