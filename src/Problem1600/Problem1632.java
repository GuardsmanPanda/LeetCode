package Problem1600;

import java.util.*;

public class Problem1632 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        int[] colRank = new int[matrix[0].length];
        int[] rowRank = new int[matrix.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.add(new int[]{i, j, matrix[i][j]});
            }
        }

        while (!queue.isEmpty()) {
            int val = queue.peek()[2];
            ArrayDeque<int[]> nq = new ArrayDeque<>();
            while (queue.size() > 0 && queue.peek()[2] == val) {
                nq.add(queue.remove());
            }
            HashSet<Integer> usedCol = new HashSet<>();
            HashSet<Integer> usedRow = new HashSet<>();

            while (!nq.isEmpty()) {
                List<int[]> neighbors = new ArrayList<>();
                int[] cur = nq.remove();
                usedRow.add(cur[0]);
                usedCol.add(cur[1]);
                neighbors.add(cur);
                int target = nq.size();
                while (target-- > 0) {
                    int[] item = nq.removeFirst();
                    if (usedRow.contains(item[0]) || usedCol.contains(item[1])) {
                        usedCol.add(item[1]);
                        usedRow.add(item[0]);
                        neighbors.add(item);
                        target = nq.size();
                    } else {
                        nq.addLast(item);
                    }
                }
                int maxRank = 0;
                for (int[] neighbor : neighbors) {
                    int i = neighbor[0];
                    int j = neighbor[1];
                    maxRank = Math.max(maxRank, colRank[j] + 1);
                    maxRank = Math.max(maxRank, rowRank[i] + 1);
                }
                for (int[] neighbor : neighbors) {
                    int i = neighbor[0];
                    int j = neighbor[1];
                    colRank[j] = maxRank;
                    rowRank[i] = maxRank;
                    ans[i][j] = maxRank;
                }
            }
        }
        return ans;
    }
}
