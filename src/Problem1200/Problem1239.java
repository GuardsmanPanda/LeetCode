package Problem1200;

import java.util.List;

public class Problem1239 {
    public int maxLength(List<String> arr) {
        int[] a = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            for (char c : arr.get(i).toCharArray()) {
                if ((a[i] & (1 << (c - 'a'))) != 0) {
                    a[i] = 0;
                    break;
                }
                a[i] |= 1 << (c - 'a');
            }
        }
        return Integer.bitCount(genMax(a, 0, 0));
    }

    private int genMax(int[] arr, int idx, int cur) {
        if (idx == arr.length) {
            return cur;
        }
        int res = genMax(arr, idx + 1, cur);
        if (arr[idx] != 0 && (cur & arr[idx]) == 0) {
            int tmp = genMax(arr, idx + 1, cur | arr[idx]);
            if (Integer.bitCount(tmp) > Integer.bitCount(res)) {
                res = tmp;
            }
        }
        return res;
    }
}
