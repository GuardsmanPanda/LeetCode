package Problem1400;

import Types.BinaryMatrix;

public class Problem1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int h = binaryMatrix.dimensions().get(0);
        int w = binaryMatrix.dimensions().get(1);
        int min = w;
        for (int i = 0; i < h; i++) {
            int left = 0, right = w - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (binaryMatrix.get(i, mid) == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (binaryMatrix.get(i, left) == 1) {
                min = Math.min(min, left);
            }
        }
        return min == w ? -1 : min;
    }
}
