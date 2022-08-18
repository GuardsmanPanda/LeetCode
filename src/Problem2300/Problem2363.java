package Problem2300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] count = new int[1001];
        for (int[] ints : items1) {
            count[ints[0]] += ints[1];
        }
        for (int[] ints : items2) {
            count[ints[0]] += ints[1];
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (count[i] != 0) {
                result.add(Arrays.asList(i, count[i]));
            }
        }
        return result;
    }
}
