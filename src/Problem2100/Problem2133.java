package Problem2100;

public class Problem2133 {
    public boolean checkValid(int[][] matrix) {
        for (int[] row : matrix) {
            boolean[] found = new boolean[row.length];
            for (int j : row) {
                if (found[j - 1]) {
                    return false;
                }
                found[j - 1] = true;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            boolean[] found = new boolean[matrix.length];
            for (int[] row : matrix) {
                if (found[row[i] - 1]) {
                    return false;
                }
                found[row[i] - 1] = true;
            }
        }
        return true;
    }
}
