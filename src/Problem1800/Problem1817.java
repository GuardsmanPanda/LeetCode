package Problem1800;

import java.util.*;

public class Problem1817 {
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Arrays.stream(logs).forEach(log -> map.computeIfAbsent(log[0], key -> new HashSet<>()).add(log[1]));
        int[] result = new int[k];
        map.values().forEach(set -> result[set.size() - 1]++);
        return result;
    }
}
