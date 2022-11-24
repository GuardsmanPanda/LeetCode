package Problem200;

import java.util.ArrayList;
import java.util.List;

public class Problem247 {
    private final List<String> result = new ArrayList<>();
    private final char[][] flip = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    private final char[] middle = {'0', '1', '8'};
    public List<String> findStrobogrammatic(int n) {
        solve(new char[n], 0, n - 1);
        return result;
    }

    private void solve(char[] arr, int left, int right) {
        if (left > right) {
            result.add(new String(arr));
            return;
        }
        if (left == right) {
            for (char c : middle) {
                arr[left] = c;
                solve(arr, left + 1, right - 1);
            }
        } else {
            for (char[] pair : flip) {
                arr[left] = pair[0];
                arr[right] = pair[1];
                if (left != 0 || arr[left] != '0') {
                    solve(arr, left + 1, right - 1);
                }
            }
        }
    }
}
