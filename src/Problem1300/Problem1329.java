package Problem1300;

import java.util.Arrays;

public class Problem1329 {
    public int[][] diagonalSort(int[][] mat) {
        int[] aux = new int[Math.max(mat.length, mat[0].length)];
        for (int i = 0; i < mat.length; i++) {
            sort(mat, i, 0, aux);
        }
        for (int j = 1; j < mat[0].length; j++) {
            sort(mat, 0, j, aux);
        }
        return mat;
    }

    private void sort(int[][] mat, int row, int col, int[] aux) {
        int idx = 0;
        while (row < mat.length && col < mat[0].length) {
            aux[idx++] = mat[row++][col++];
        }
        Arrays.sort(aux, 0, idx);
        while (--row >= 0 && --col >= 0) {
            mat[row][col] = aux[--idx];
        }
    }
}
