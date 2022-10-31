package Problem1500;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1514 {
    private record Location(int idx, double prob) { }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(i);
            graph.get(edges[i][1]).add(i);
        }
        PriorityQueue<Location> queue = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        queue.add(new Location(start, 1));
        double[] maxProb = new double[n];
        maxProb[start] = 1;
        while (queue.size() > 0) {
            Location loc = queue.remove();
            if (loc.idx == end) {
                return loc.prob;
            }
            for (int i : graph.get(loc.idx)) {
                int next = edges[i][0] == loc.idx ? edges[i][1] : edges[i][0];
                double prob = loc.prob * succProb[i];
                if (prob > maxProb[next]) {
                    maxProb[next] = prob;
                    queue.add(new Location(next, prob));
                }
            }
        }
        return 0;
    }
}
