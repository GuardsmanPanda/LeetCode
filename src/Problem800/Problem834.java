package Problem800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem834 {
    private final List<List<Integer>> adjacencyList = new ArrayList<>();
    private int[] subTreeSize, sumOfDistances;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        for(int i=0; i<n; i++){
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        sumOfDistances = new int[n];
        subTreeSize = new int[n];
        dfs(0, -1);
        System.out.println(Arrays.toString(sumOfDistances));
        System.out.println(Arrays.toString(subTreeSize));
        dfs2(0, -1);

        return sumOfDistances;
    }

    private void dfs(int node, int parent){
        subTreeSize[node] = 1;
        for(int child : adjacencyList.get(node)){
            if(child == parent){
                continue;
            }
            dfs(child, node);
            subTreeSize[node] += subTreeSize[child];
            sumOfDistances[node] += sumOfDistances[child] + subTreeSize[child];
        }
    }

    private void dfs2(int node, int parent) {
        for(int child : adjacencyList.get(node)){
            if(child == parent){
                continue;
            }
            sumOfDistances[child] = sumOfDistances[node] + (adjacencyList.size() - subTreeSize[child]) - subTreeSize[child];
            dfs2(child, node);
        }
    }
}
