package Problem200;

import java.util.ArrayList;
import java.util.List;

public class Problem282 {
    public List<String> addOperators(String num, int target) {
        char[] arr = new char[num.length() * 2 - 1];
        for (int i = 0; i < num.length(); i++) {
            arr[i * 2] = num.charAt(i);
        }
        return solve(arr, 0, 0, target, new ArrayList<>());
    }

    private List<String> solve(char[] a, int idx, long val, long target, List<String> result) {
        if (idx >= a.length) {
            if (val == target) {
                result.add(new String(a));
            }
        } else {
            long sum = 1;
            for (int i = idx; i < a.length; i += 2) {
                sum *= a[i] - '0';
                if (i > idx) {
                    a[i-1] = '*';
                }
                if (idx > 0) {
                    a[idx - 1] = '+';
                    solve(a, i + 2, val + sum, target, result);
                    a[idx - 1] = '-';
                    solve(a, i + 2, val - sum, target, result);
                } else {
                    solve(a, i + 2, sum, target, result);
                }
            }
        }
        return result;
    }
}
