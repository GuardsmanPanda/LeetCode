package Problem1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]> dist = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                dist.add(new int[]{i, j, Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1])});
            }
        }
        dist.sort((a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        int[] res = new int[workers.length];
        boolean[] used = new boolean[bikes.length];
        Arrays.fill(res, -1);
        for (int[] cur : dist) {
            if (res[cur[0]] == -1 && !used[cur[1]]) {
                res[cur[0]] = cur[1];
                used[cur[1]] = true;
            }
        }
        return res;
    }
}
