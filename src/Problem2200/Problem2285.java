package Problem2200;

import java.util.Arrays;

public class Problem2285 {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += degree[i] * (long) (i + 1);
        }
        return res;
    }
}
