import java.util.Arrays;

public class Problem2132 {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int[][] prefix = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        int[][] stampHit = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int bottom = i + stampHeight - 1;
                int right = j + stampWidth - 1;
                if (bottom >= grid.length || right >= grid[0].length) {
                    continue;
                }
                int sum = prefix[bottom + 1][right + 1] - prefix[i][right + 1] - prefix[bottom + 1][j] + prefix[i][j];
                if (sum == 0) {
                    stampHit[i][j] = 1;
                }
            }
        }

        int[][] stampPrefix = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                stampPrefix[i][j] = stampPrefix[i - 1][j] + stampPrefix[i][j - 1] - stampPrefix[i - 1][j - 1] + stampHit[i - 1][j - 1];
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int top = Math.max(0, i - stampHeight + 1);
                int left = Math.max(0, j - stampWidth + 1);
                int sum = stampPrefix[i + 1][j + 1] - stampPrefix[top][j + 1] - stampPrefix[i + 1][left] + stampPrefix[top][left];
                if (sum == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
