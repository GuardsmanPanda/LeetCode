package Problem2300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem2392 {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> rowGraph = new ArrayList<>();
        List<List<Integer>> colGraph = new ArrayList<>();
        int[] rInDegree = new int[k + 1];
        int[] cInDegree = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            rowGraph.add(new ArrayList<>());
            colGraph.add(new ArrayList<>());
        }
        for (int[] rowCondition : rowConditions) {
            rowGraph.get(rowCondition[0]).add(rowCondition[1]);
            rInDegree[rowCondition[1]]++;
        }
        for (int[] colCondition : colConditions) {
            colGraph.get(colCondition[0]).add(colCondition[1]);
            cInDegree[colCondition[1]]++;
        }
        int[] rowOrder = topologicalSort(rowGraph, rInDegree);
        int[] colOrder = topologicalSort(colGraph, cInDegree);
        if (rowOrder == null || colOrder == null) {
            return new int[0][0];
        }
        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            matrix[rowOrder[i]][colOrder[i]] = i;
        }
        return matrix;
    }

    private int[] topologicalSort(List<List<Integer>> graph, int[] inDegree) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[inDegree.length];
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[node] = index++;
            for (int next : graph.get(node)) {
                if (--inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return index == inDegree.length - 1 ? result : null;
    }
}
