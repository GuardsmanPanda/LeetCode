package Problem1500;

public class Problem1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - m * k; i++) {
            int idx = i, cnt = 0, j = 0;
            while (cnt < k && arr[idx++] == arr[i + j++]) {
                if (j == m) {
                    j = 0;
                    cnt++;
                }
            }
            if (cnt == k) {
                return true;
            }
        }
        return false;
    }
}
