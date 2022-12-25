package Problem2500;

import java.util.Arrays;

public class Problem2500 {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] g : grid) {
            Arrays.sort(g);
        }
        int result = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int idx = i;
            result += Arrays.stream(grid).mapToInt(g -> g[idx]).max().orElse(0);
        }
        return result;
    }
}
