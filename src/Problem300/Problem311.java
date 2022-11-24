package Problem300;

import java.util.ArrayList;
import java.util.List;

public class Problem311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        List<List<int[]>> mat1List = new ArrayList<>();
        for (int[] row : mat1) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < row.length; i++) {
                if (row[i] != 0) {
                    list.add(new int[]{i, row[i]});
                }
            }
            mat1List.add(list);
        }
        int[][] result = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < mat1List.size(); i++) {
            for (int[] pair : mat1List.get(i)) {
                int idx = pair[0];
                int val = pair[1];
                for (int j = 0; j < mat2[0].length; j++) {
                    result[i][j] += val * mat2[idx][j];
                }
            }
        }
        return result;
    }
}
