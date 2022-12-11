package Problem1200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j : beforeItems.get(i)) {
                if (group[i] != group[j]) {
                    groupGraph.get(group[j]).add(group[i]);
                }
            }
        }
        int[] groupOrder = topologicalSort(group, beforeItems);
        System.out.println(Arrays.toString(group));
        System.out.println(Arrays.toString(groupOrder));
        return groupOrder;
    }

    private int[] topologicalSort(List<List<Integer>> graph) {
        int[] inDegree = new int[graph.size()];
        for (List<Integer> node : graph) {
            for (int j : node) {
                inDegree[j]++;
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        int[] result = new int[graph.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            result[idx++] = cur;
            for (int i : graph.get(cur)) {
                if (--inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }
}
