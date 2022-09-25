package Problem2000;

public class Problem2087 {

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int x1 = startPos[0], y1 = startPos[1], x2 = homePos[0], y2 = homePos[1];
        int sum = 0;
        if (x1 < x2) {
            for (int i = x1; i < x2; i++) {
                sum += rowCosts[i + 1];
            }
        } else {
            for (int i = x2; i < x1; i++) {
                sum += rowCosts[i];
            }
        }
        if (y1 < y2) {
            for (int i = y1; i < y2; i++) {
                sum += colCosts[i + 1];
            }
        } else {
            for (int i = y2; i < y1; i++) {
                sum += colCosts[i];
            }
        }
        return sum;
    }
}
