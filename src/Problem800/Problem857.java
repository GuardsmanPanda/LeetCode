package Problem800;

import java.util.PriorityQueue;

public class Problem857 {
    record Worker(int quality, int wage, double costPerQuality) implements Comparable<Worker> {
        @Override
        public int compareTo(Worker o) {
            return Double.compare(costPerQuality, o.costPerQuality);
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        PriorityQueue<Worker> queue = new PriorityQueue<>();
        for (int i = 0; i < quality.length; i++) {
            queue.add(new Worker(quality[i], wage[i], (double)wage[i]/quality[i]));
        }
        double minCost = Integer.MAX_VALUE;
        int totalQuality = 0;
        PriorityQueue<Integer> qualityQueue = new PriorityQueue<>((a, b) -> b - a);
        while (queue.size() > 0) {
            Worker worker = queue.remove();
            totalQuality += worker.quality;
            qualityQueue.add(worker.quality);
            if (qualityQueue.size() > k) {
                totalQuality -= qualityQueue.remove();
            }
            if (qualityQueue.size() == k) {
                minCost = Math.min(minCost, totalQuality * worker.costPerQuality);
            }
        }
        return minCost;
    }
}
