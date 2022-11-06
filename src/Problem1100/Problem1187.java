package Problem1100;

import java.util.Arrays;

public class Problem1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int[][] lowest = new int[arr1.length][arr2.length + 1];
        for (int i = 0; i < arr1.length; i++) {
            Arrays.fill(lowest[i], Integer.MAX_VALUE);
        }
        int res = solve(0, 0, arr1, arr2, 0, lowest, -1);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int solve(int idx1, int idx2, int[] a, int[] b, int ops, int[][] lowest, int last) {
        if (idx1 == a.length) {
            return ops;
        }
        if (ops >= lowest[idx1][idx2]) {
            return lowest[idx1][idx2];
        }
        if (a[idx1] > last) {
            lowest[idx1][idx2] = Math.min(lowest[idx1][idx2], solve(idx1 + 1, idx2, a, b, ops, lowest, a[idx1]));
        }
        int low = idx2, high = b.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (b[mid] > last) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low < b.length && b[low] > last) {
            lowest[idx1][idx2] = Math.min(lowest[idx1][idx2], solve(idx1 + 1, low + 1, a, b, ops + 1, lowest, b[low]));
        }
        return lowest[idx1][idx2];
    }
}
