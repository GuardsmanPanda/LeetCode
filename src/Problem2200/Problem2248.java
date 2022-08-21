package Problem2200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2248 {
    public List<Integer> intersection(int[][] nums) {
        boolean[] seen = new boolean[1001];
        boolean[] next = new boolean[1001];
        Arrays.fill(seen, true);
        for (int[] num : nums) {
            Arrays.fill(next, false);
            for (int i : num) {
                if (seen[i]) {
                    next[i] = true;
                }
            }
            for (int i = 0; i < seen.length; i++) {
                seen[i] = seen[i] && next[i];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < seen.length; i++) {
            if (seen[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
