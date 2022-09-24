package Problem1700;

public class Problem1762 {
    public int[] findBuildings(int[] heights) {
        int count = 0, max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                count++;
            }
        }
        int[] res = new int[count];
        max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                res[--count] = i;
            }
        }
        return res;
    }
}
