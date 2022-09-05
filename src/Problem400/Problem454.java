package Problem400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Arrays.sort(A);
        for (int aC : C) {
            for (int aD : D) {
                int sum = aC + aD;
                countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int j : A) {
            int firstCount = 0;
            for (int aB : B) {
                firstCount += countMap.getOrDefault(-(j + aB), 0);
            }
            count += firstCount;
        }
        return count;
    }
}
