package Problem900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Problem947 {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>(), colMap = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int[] stone : stones) {
            int node = graph.size();
            graph.add(new ArrayList<>());
            List<Integer> row = rowMap.computeIfAbsent(stone[0], integer -> new ArrayList<>());
            List<Integer> col = colMap.computeIfAbsent(stone[1], integer -> new ArrayList<>());
            row.forEach(r -> {
                graph.get(r).add(node);
                graph.get(node).add(r);
            });
            col.forEach(c -> {
                graph.get(c).add(node);
                graph.get(node).add(c);
            });
            row.add(node);
            col.add(node);
        }
        boolean[] vis = new boolean[graph.size()];
        int res = graph.size();
        for (int i = 0; i < graph.size(); i++) {
            if (!vis[i]) {
                visitComp(i, graph, vis);
                res--;
            }
        }
        return res;
    }
    private void visitComp(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (Integer adj : graph.get(node))
            if (!visited[adj])
                visitComp(adj, graph, visited);
    }
}
