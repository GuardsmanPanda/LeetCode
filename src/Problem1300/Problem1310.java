package Problem1300;

import java.util.Arrays;

public class Problem1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        return Arrays.stream(queries).mapToInt(q -> prefix[q[0]] ^ prefix[q[1] + 1]).toArray();
    }
}
