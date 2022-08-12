package Problem1900;

import java.util.Arrays;

public class Problem1901 {
    public int[] findPeakGrid(int[][] mat) {
        System.out.println(Arrays.deepToString(mat));
        int[][] m = new int[mat.length + 2][mat[0].length + 2];
        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, m[i + 1], 1, mat[i].length);
            m[i + 1][m[i + 1].length - 1] = -1;
            m[i + 1][0] = -1;
        }
        Arrays.fill(m[m.length - 1], -1);
        Arrays.fill(m[0], -1);

        int left = 1, right = m.length - 2;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int col = 1;
            while (m[mid][col] < m[mid][col + 1]) {
                col++;
            }
            System.out.println("mid = " + mid + ", col = " + col);
            System.out.println(Arrays.toString(m[mid]));
            if (m[mid - 1][col] < m[mid][col] && m[mid + 1][col] < m[mid][col]) {
                return new int[]{mid - 1, col - 1};
            } else if (m[mid - 1][col] > m[mid][col]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int col = 1;
        while (m[left][col] < m[left][col + 1]) {
            col++;
        }
        return new int[]{left - 1, col - 1};
    }
}
