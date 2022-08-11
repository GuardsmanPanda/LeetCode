package Problem2200;

import java.util.Arrays;

public class Problem2242 {
    public int maximumScore(int[] scores, int[][] edges) {
        int[][][] largestAdj = new int[scores.length][3][2];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int sa = scores[a];
            int sb = scores[b];
            if (sa > largestAdj[b][2][0]) {
                largestAdj[b][2][0] = sa;
                largestAdj[b][2][1] = a;
                if (largestAdj[b][2][0] > largestAdj[b][1][0]) {
                    int[] tmp = largestAdj[b][1];
                    largestAdj[b][1] = largestAdj[b][2];
                    largestAdj[b][2] = tmp;
                }
                if (largestAdj[b][1][0] > largestAdj[b][0][0]) {
                    int[] tmp = largestAdj[b][0];
                    largestAdj[b][0] = largestAdj[b][1];
                    largestAdj[b][1] = tmp;
                }
            }
            if (sb > largestAdj[a][2][0]) {
                largestAdj[a][2][0] = sb;
                largestAdj[a][2][1] = b;
                if (largestAdj[a][2][0] > largestAdj[a][1][0]) {
                    int[] tmp = largestAdj[a][1];
                    largestAdj[a][1] = largestAdj[a][2];
                    largestAdj[a][2] = tmp;
                }
                if (largestAdj[a][1][0] > largestAdj[a][0][0]) {
                    int[] tmp = largestAdj[a][0];
                    largestAdj[a][0] = largestAdj[a][1];
                    largestAdj[a][1] = tmp;
                }
            }
        }
        //for (int i = 0; i < largestAdj.length; i++) {
        //    System.out.println("" + i + ": " + Arrays.deepToString(largestAdj[i]));
        //}

        int max = -1;
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int combo = 0;
            int[][] aa = largestAdj[a];
            int[][] bb = largestAdj[b];
            for (int i = 0; i < 3; i++) {
                if (aa[i][1] == b || aa[i][0] == 0) {
                    continue;
                }
                for (int j = 0; j < 3; j++) {
                    if (bb[j][1] == a || bb[j][0] == 0 || aa[i][1] == bb[j][1]) {
                        continue;
                    }
                    combo = Math.max(combo, aa[i][0] + bb[j][0]);
                    //System.out.println("edge " + a + " " + b + ", i: " + i + ", j: " + j + ", total: " + (combo + scores[a] + scores[b]));
                }
            }
            if (combo != 0) {
                max = Math.max(max, combo + scores[a] + scores[b]);
            }
        }
        return max;
    }
}
