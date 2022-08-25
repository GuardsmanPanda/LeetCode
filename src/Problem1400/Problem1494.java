package Problem1400;

import java.util.*;

public class Problem1494 {
    private final int INF = 1_000_000;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] relation : relations) {
            graph.get(relation[0] - 1).add(relation[1] - 1);
            inDegree[relation[1] - 1]++;
        }
        int[] dist = new int[1 << n];
        Arrays.fill(dist, INF);
        dist[(1 << n) - 1] = 0;
        solve(0, dist, graph, inDegree, k);
        return dist[0];
    }

    private int solve(int state, int[] dist, List<List<Integer>> graph, int[] inDeg, int k) {
        if (dist[state] != INF) {
            return dist[state];
        }
        List<List<Integer>> newStates = generate(0, state, inDeg, k, new ArrayList<>(), new ArrayList<>());
        int maxLen = 0;
        for (List<Integer> newState : newStates) {
            maxLen = Math.max(maxLen, newState.size());
        }
        System.out.println("state: " + Integer.toBinaryString(state) + " maxLen: " + maxLen);
        //System.out.println("newStates: " + newStates);
        for (List<Integer> newState : newStates) {
            if (newState.size() < maxLen) {
                continue;
            }
            int nextState = state;
            for (int i : newState) {
                nextState |= 1 << i;
                for (Integer adj : graph.get(i)) {
                    inDeg[adj]--;
                }
            }
            dist[state] = Math.min(dist[state], solve(nextState, dist, graph, inDeg, k) + 1);
            for (int i : newState) {
                for (Integer adj : graph.get(i)) {
                    inDeg[adj]++;
                }
            }
        }
        return dist[state];
    }

    private List<List<Integer>> generate(int idx, int state, int[] inDeg, int k, List<List<Integer>> res, List<Integer> cur) {
        if (idx == inDeg.length || k == 0) {
            if (cur.size() > 0) {
                res.add(new ArrayList<>(cur));
            }
            return res;
        }
        generate(idx + 1, state, inDeg, k, res, cur);
        if ((state & (1 << idx)) == 0 && inDeg[idx] == 0) {
            cur.add(idx);
            generate(idx + 1, state | (1 << idx), inDeg, k - 1, res, cur);
            cur.remove(cur.size() - 1);
        }
        return res;
    }
}
