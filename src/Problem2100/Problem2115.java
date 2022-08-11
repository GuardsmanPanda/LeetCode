package Problem2100;

import java.util.*;

public class Problem2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> graphMap = new HashMap<>(recipes.length + supplies.length);
        for (int i = 0; i < recipes.length; i++) {
            graphMap.put(recipes[i], i);
        }
        for (String supply : supplies) {
            graphMap.put(supply, graphMap.size());
        }

        List<List<Integer>> graph = new ArrayList<>(graphMap.size());
        for (int i = 0; i < graphMap.size(); i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDeg = new int[graphMap.size()];
        for (int i = 0; i < ingredients.size(); i++) {
            for (String ingredient : ingredients.get(i)) {
                inDeg[i]++;
                if (graphMap.containsKey(ingredient)) {
                    graph.get(graphMap.get(ingredient)).add(i);
                }
            }
        }
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(supplies));
        List<String> res = new ArrayList<>();
        while (queue.size() > 0) {
            String cur = queue.remove();
            int curIdx = graphMap.get(cur);
            for (int adj : graph.get(curIdx)) {
                if (--inDeg[adj] == 0) {
                    res.add(recipes[adj]);
                    queue.add(recipes[adj]);
                }
            }
        }
        return res;
    }
}
