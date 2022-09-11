package Problem1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[] colMax = new int[matrix[0].length];
        int[] rowMin = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rowMin[i] = matrix[i][0];
            for (int j = 0; j < matrix[i].length; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }
}
