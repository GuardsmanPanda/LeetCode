package Problem200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {
            graph.get(course[0]).add(course[1]);
        }
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasDirectedCycle(i, graph, state))
                return false;
            state[i] = 2;
        }
        return true;
    }
    private boolean hasDirectedCycle(int node, List<List<Integer>> graph, int[] state) {
        state[node] = 1;
        for (Integer adj : graph.get(node)) {
            if (state[adj] == 1)
                return true;
            else if (state[adj] == 0 && hasDirectedCycle(adj, graph, state))
                return true;
            state[adj] = 2;
        }
        return false;
    }
}
