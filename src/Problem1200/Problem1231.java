package Problem1200;

public class Problem1231 {
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = 0, high = 1_000_000_000;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            int count = 0, cur = 0;
            for (int i : sweetness) {
                cur += i;
                if (cur >= mid) {
                    count++;
                    cur = 0;
                }
            }
            if (count >= k + 1) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
