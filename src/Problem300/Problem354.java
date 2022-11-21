package Problem300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<Integer> list = new ArrayList<>();
        for (int[] env : envelopes) {
            int height = env[1];
            int low = 0, high = list.size();
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (list.get(mid) < height) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (low == list.size()) {
                list.add(height);
            } else {
                list.set(low, height);
            }
        }
        return list.size();
    }
}
