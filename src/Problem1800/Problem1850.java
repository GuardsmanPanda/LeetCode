package Problem1800;

import java.util.Arrays;

public class Problem1850 {
    public int getMinSwaps(String num, int k) {
        char[] arr = num.toCharArray(), original = num.toCharArray();
        while (k --> 0) { // Move to the next permutation k times
            int idx = arr.length - 2, ndx = arr.length - 1;
            while (idx >= 0 && arr[idx] >= arr[idx + 1]) {
                idx--;
            }
            while (arr[ndx] <= arr[idx]) {
                ndx--;
            }
            char tmp = arr[idx];
            arr[idx] = arr[ndx];
            arr[ndx] = tmp;
            Arrays.sort(arr, idx + 1, arr.length);
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            while (original[idx] != arr[i]) {
                idx++;
            }
            while (idx > i) {
                char tmp = original[idx];
                original[idx] = original[idx - 1];
                original[idx - 1] = tmp;
                idx--;
                result++;
            }
        }
        return result;
    }
}
