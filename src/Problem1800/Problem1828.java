package Problem1800;

import java.util.Arrays;

public class Problem1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = (int)Arrays.stream(points)
                    .filter(point -> Math.pow(point[0] - query[0], 2) + Math.pow(point[1] - query[1], 2) <= Math.pow(query[2], 2))
                    .count();
        }
        return res;
    }
}
