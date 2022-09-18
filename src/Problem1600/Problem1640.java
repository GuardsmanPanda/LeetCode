package Problem1600;

import java.util.Arrays;

public class Problem1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] index = new int[101];
        Arrays.fill(index, -1);
        for (int i = 0; i < pieces.length; i++) {
            index[pieces[i][0]] = i;
        }
        for (int i = 0; i < arr.length;) {
            if (index[arr[i]] == -1) {
                return false;
            }
            for (int k : pieces[index[arr[i]]]) {
                if (k != arr[i++]) {
                    return false;
                }
            }
        }
        return true;
    }
}
