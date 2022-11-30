package Problem200;

public class Problem221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxSize = 0;
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            arr[0][i] = matrix[0][i] - '0';
            maxSize = Math.max(maxSize, arr[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            arr[i][0] = matrix[i][0] - '0';
            maxSize = Math.max(maxSize, arr[i][0]);
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    arr[i][j] = Math.min(arr[i][j-1], Math.min(arr[i-1][j],arr[i-1][j-1])) + 1;
                    maxSize = Math.max(maxSize, arr[i][j]);
                }
            }
        }
        return maxSize*maxSize;
    }
}
