package Problem600;

public class Problem668 {
    public int findKthNumber(int m, int n, int k) {
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        int low = 1, high = m * n;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
