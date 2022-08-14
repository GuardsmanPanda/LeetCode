package Problem500;

public class Problem562 {
    public int longestLine(int[][] mat) {
        int[][][] len = new int[mat.length + 1][mat[0].length + 2][4];
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    len[i + 1][j + 1][0] = len[i][j + 1][0] + 1;
                    len[i + 1][j + 1][1] = len[i][j][1] + 1;
                    len[i + 1][j + 1][2] = len[i + 1][j][2] + 1;
                    len[i + 1][j + 1][3] = len[i][j + 2][3] + 1;
                    max = Math.max(max, len[i + 1][j + 1][0]);
                    max = Math.max(max, len[i + 1][j + 1][1]);
                    max = Math.max(max, len[i + 1][j + 1][2]);
                    max = Math.max(max, len[i + 1][j + 1][3]);
                }
            }
        }
        return max;
    }
}
