package Problem1900;

import java.util.ArrayList;
import java.util.List;

public class Problem1940 {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int[] counts = new int[101];
        for (int[] array : arrays) {
            for (int num : array) {
                counts[num]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == arrays.length) {
                result.add(i);
            }
        }
        return result;
    }
}
