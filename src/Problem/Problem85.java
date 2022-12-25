package Problem;

public class Problem85 {
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int maxLen = Integer.MAX_VALUE;
                for (int k = 0; k + i < matrix.length; k++) {
                    int len = 0;
                    while (j + len < matrix[0].length && matrix[i + k][j + len] == '1') {
                        len++;
                    }
                    maxLen = Math.min(maxLen, len);
                    result = Math.max(result, maxLen * (k + 1));
                }
            }
        }
        return result;
    }
}
