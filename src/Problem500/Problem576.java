package Problem500;

public class Problem576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int[][] current = new int[m][n];
        current[i][j] = 1;
        long total = 0;
        int MOD = 1_000_000_007;
        for (int k = 0; k < N; k++) {
            int[][] next = new int[m][n];
            for (int mm = 0; mm < m; mm++) {
                for (int nn = 0; nn < n; nn++) {
                    for (int[] dir : directions) {
                        int x = mm+dir[0], y = nn + dir[1];
                        if (x < 0 || y < 0 || x >= m || y >= n)
                            total += current[mm][nn];
                        else next[mm][nn] = (next[mm][nn]+current[x][y])%MOD;
                    }
                }
            }
            current = next;
            total %= MOD;
        }
        return (int)total;
    }
}
