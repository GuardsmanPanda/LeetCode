package Problem1900;

import java.util.Arrays;

public class Problem1901 {
    public int[] findPeakGrid(int[][] mat) {
        int left = 0, right = mat.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int maxIdx = 0;
            for (int i = 1; i < mat[0].length; i++) {
                if (mat[mid][i] > mat[mid][maxIdx]) {
                    maxIdx = i;
                }
            }
            if ((mid == 0 || mat[mid - 1][maxIdx] < mat[mid][maxIdx]) && (mid == mat.length -1 || mat[mid + 1][maxIdx] < mat[mid][maxIdx])) {
                return new int[]{mid, maxIdx};
            } else if (mid > 0 && mat[mid - 1][maxIdx] > mat[mid][maxIdx]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int maxIdx = 1;
        for (int i = 1; i < mat[0].length; i++) {
            if (mat[left][i] > mat[left][maxIdx]) {
                maxIdx = i;
            }
        }
        return new int[]{left, maxIdx};
    }
}
