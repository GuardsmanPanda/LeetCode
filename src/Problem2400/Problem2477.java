package Problem2400;

import java.util.ArrayList;
import java.util.List;

public class Problem2477 {
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= roads.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        return dfs(graph, 0, -1, seats)[0];
    }

    private long[] dfs(List<List<Integer>> graph, int node, int parent, int seats) {
        long[] result = {0, 1}; // cost, passengers
        for (int child : graph.get(node)) {
            if (child != parent) {
                long[] childResult = dfs(graph, child, node, seats);
                result[0] += childResult[0];
                result[1] += childResult[1];
            }
        }
        if (node != 0) {
            result[0] += (result[1] + seats - 1) / seats;
        }
        return result;
    }
}
