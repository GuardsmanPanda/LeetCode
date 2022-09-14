package Problem1500;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Problem1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] cnt = new int[n + 1];
        cnt[rounds[0]]++;
        for (int i = 1; i < rounds.length; i++) {
            int start = rounds[i - 1], end = rounds[i];
            while (start != end) {
                cnt[start = start % n + 1]++;
            }
        }
        int max = Arrays.stream(cnt).max().orElse(0);
        return IntStream.range(1, n + 1).filter(i -> cnt[i] == max).boxed().toList();
    }
}
