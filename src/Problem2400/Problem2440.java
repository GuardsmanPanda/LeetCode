package Problem2400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2440 {
    public int componentValue(int[] nums, int[][] edges) {
        int sum = Arrays.stream(nums).sum();
        List<List<Integer>> graph = new ArrayList<>();
        for (int num : nums) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[nums.length];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        for (int i = 1; i <= sum; i++) {
            if (sum % i == 0 && canSolve(graph, Arrays.copyOf(degree, degree.length), i, nums)) {
                return sum / i - 1;
            }
        }
        return 0;
    }

    private boolean canSolve(List<List<Integer>> graph, int[] deg, int target, int[] values) {
        int[] val = new int[graph.size()];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < deg.length; i++) {
            if (deg[i] <= 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            val[node] += values[node];
            if (val[node] > target) {
                return false;
            }
            val[node] %= target;
            for (int next : graph.get(node)) {
                if (--deg[next] == 1) {
                    queue.add(next);
                }
                val[next] += val[node];
            }
            val[node] = -1;
        }
        return true;
    }
}
