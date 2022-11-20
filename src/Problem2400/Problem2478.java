package Problem2400;

import java.util.Arrays;

public class Problem2478 {
    public int beautifulPartitions(String s, int k, int minLength) {
        char[] arr = s.toCharArray();
        if (arr[0] != '2' && arr[0] != '3' && arr[0] != '5' && arr[0] != '7') {
            return 0;
        }
        int[] cur = new int[s.length() + 1];
        cur[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] next = new int[s.length() + 1];
            int started = 0;
            for (int j = minLength * (i + 1); j < cur.length; j++) {
                if (j >= minLength) {
                    started += cur[j - minLength];
                    started %= 1000000007;
                }
                if (j < arr.length && (arr[j] != '2' && arr[j] != '3' && arr[j] != '5' && arr[j] != '7')) {
                    continue;
                }
                if (arr[j - 1] != '2' && arr[j - 1] != '3' && arr[j - 1] != '5' && arr[j - 1] != '7') {
                    next[j] = started % 1000000007;
                }
            }
            cur = next;
        }
        return cur[cur.length - 1];
    }
}
