package Problem2500;

import java.util.Arrays;

public class Problem2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0, high = price[price.length - 1] - price[0];
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (check(price, mid, k)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean check(int[] price, int mid, int k) {
        int count = 0, last = -mid;
        for (int i : price) {
            if (i - last >= mid) {
                last = i;
                count++;
            }
        }
        return count >= k;
    }
}
