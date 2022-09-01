package Problem1300;

import java.util.Arrays;
import java.util.HashMap;

public class Problem1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[] brr = new int[arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        Arrays.sort(brr);
        int last = brr[0] + 1, cur = 1;
        HashMap<Integer, Integer> mapping = new HashMap<>(arr.length);
        for (int j : brr) {
            if (j != last) {
                last = j;
                mapping.put(j, cur++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = mapping.get(arr[i]);
        }
        return arr;
    }
}
