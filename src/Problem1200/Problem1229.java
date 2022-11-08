package Problem1200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[1]));
        int idx1 = 0, idx2 = 0;
        while (idx1 < slots1.length && idx2 < slots2.length) {
            int[] slot1 = slots1[idx1];
            int[] slot2 = slots2[idx2];
            int maxStart = Math.max(slot1[0], slot2[0]);
            int minEnd = Math.min(slot1[1], slot2[1]);
            if ((long)maxStart + duration <= minEnd) {
                return List.of(maxStart, maxStart + duration);
            }
            if (slot1[1] < slot2[1]) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return List.of();
    }
}
