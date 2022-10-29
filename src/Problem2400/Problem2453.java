package Problem2400;

import java.util.HashMap;
import java.util.Map;

public class Problem2453 {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int num : nums) {
            int n = num % space;
            int[] arr = map.computeIfAbsent(n, k -> new int[2]);
            if (arr[0] == 0) {
                arr[0] = num;
            } else {
                arr[0] = Math.min(arr[0], num);
            }
            arr[1]++;
        }
        System.out.println(map);
        return map.values().stream()
                .max((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1])
                .orElse(new int[2])[0];
    }
}
