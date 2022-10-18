package Problem1000;

import java.util.HashMap;
import java.util.Map;

public class Problem1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();
        int prime = 50943779;
        for (int[] row : matrix) {
            int zero = 0, one = 0;
            for (int i : row) {
                zero = ((zero << 2) + 1 - i) % prime;
                one = ((one << 2) + i) % prime;
            }
            map.compute(zero, (k, v) -> v == null ? 1 : v + 1);
            map.compute(one, (k, v) -> v == null ? 1 : v + 1);
        }
        int res = 0;
        for (int i : map.values()) {
            res = Math.max(res, i);
        }
        return res;
    }
}
