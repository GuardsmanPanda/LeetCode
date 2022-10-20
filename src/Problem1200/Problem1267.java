package Problem1200;

public class Problem1267 {
    public int countServers(int[][] grid) {
        int[] col = new int[grid[0].length];
        int[] row = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    col[j]++;
                    row[i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (col[j] > 1 || row[i] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }
}
