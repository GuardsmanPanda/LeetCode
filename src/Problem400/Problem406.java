package Problem400;

import java.util.Arrays;

public class Problem406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[][] result = new int[people.length][];
        for (int[] p : people) {
            int empty = p[1];
            for (int i = 0; i < result.length; i++) {
                if (result[i] == null && empty-- == 0) {
                    result[i] = p;
                    break;
                }
            }
        }
        return result;
    }
}
