package Problem900;


import java.util.ArrayList;
import java.util.List;

public class Problem969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int idx = arr.length - 1;
        while (idx > 0) {
            int max = 0;
            for (int i = 0; i <= idx; i++) {
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            if (max == idx) {
                idx--;
                continue;
            }
            if (max != 0) {
                res.add(max + 1);
                reverse(arr, max);
            }
            res.add(idx + 1);
            reverse(arr, idx);
            idx--;
        }
        return res;
    }

    private void reverse(int[] arr, int idx) {
        int i = 0;
        int j = idx;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
