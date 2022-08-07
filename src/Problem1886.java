public class Problem1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        if (areEquals(mat, target)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            mat = rotate(mat);
            if (areEquals(mat, target)) {
                return true;
            }
        }
        return false;
    }

    public int[][] rotate(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[i][j] = mat[j][mat[0].length - i - 1];
            }
        }
        return res;
    }

    private boolean areEquals(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
