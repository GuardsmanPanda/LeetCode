package Problem2200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> players = new HashMap<>();
        for (int[] m : matches) {
            players.putIfAbsent(m[0], 0);
            players.compute(m[1], (k, v) -> v == null ? 1 : v + 1);
        }
        List<Integer> zeroLoss = new ArrayList<>(), oneLoss = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : players.entrySet()) {
            if (entry.getValue() == 0) {
                zeroLoss.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                oneLoss.add(entry.getKey());
            }
        }
        zeroLoss.sort(Integer::compareTo);
        oneLoss.sort(Integer::compareTo);
        return List.of(zeroLoss, oneLoss);
    }
}
