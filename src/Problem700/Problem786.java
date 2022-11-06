package Problem700;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem786 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<double[]> queue = new PriorityQueue<>(Comparator.comparingDouble(d -> d[0]));
        for (int i = 1; i < A.length; i++) {
            queue.add(new double[] {(double)A[0]/A[i], 0, i});
        }
        while (K-- >1) {
            double[] node = queue.remove();
            if (node[1]+1 < node[2]) {
                node[1]++;
                node[0] = (double)A[(int)node[1]]/A[(int)node[2]];
                queue.add(node);
            }
        }
        return new int[] {A[(int)queue.peek()[1]],A[(int)queue.peek()[2]]};
    }
}
