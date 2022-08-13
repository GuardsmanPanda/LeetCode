package Problem1000;

import java.util.Arrays;
// [1,15,7,9,2,5,10]
public class Problem1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] score = new int[arr.length + 1];
        score[1] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int max = arr[i];
            for (int j = i; j >= 0 && j > i - k; j--) {
                max = Math.max(max, arr[j]);
                score[i + 1] = Math.max(score[i + 1], score[j] + max * (i - j + 1));
            }
        }
        return score[arr.length];
    }
}
