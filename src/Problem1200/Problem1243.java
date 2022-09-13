package Problem1200;

import java.util.List;

public class Problem1243 {
    public List<Integer> transformArray(int[] arr) {
        boolean changed = true;
        while (changed) {
            changed = false;
            int last = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < arr[i - 1] + last && arr[i] < arr[i + 1]) {
                    changed = true;
                    arr[i]++;
                    last = -1;
                } else if (arr[i] > arr[i - 1] + last && arr[i] > arr[i + 1]) {
                    changed = true;
                    arr[i]--;
                    last = 1;
                } else {
                    last = 0;
                }
            }
        }
        return java.util.stream.IntStream.of(arr).boxed().toList();
    }
}
