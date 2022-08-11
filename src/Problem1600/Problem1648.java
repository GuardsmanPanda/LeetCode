package Problem1600;

import java.util.Arrays;

public class Problem1648 {
    public int maxProfit(int[] inventory, int orders) {
        int low = 0, high = 1_000_000_000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (getCount(inventory, mid) >= orders) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        long count = getCount(inventory, low);
        long value = getValue(inventory, low) + (orders - count) * (low - 1);
        System.out.println(low);
        return (int)(value % 1_000_000_007);
    }

    private long getValue(int[] inventory, int price) {
        long res = 0;
        for (int i : inventory) {
            if (i < price) {
                continue;
            }
            res += i * ((long)i + 1) / 2 - (price * ((long)price - 1) / 2);
        }
        return res;
    }

    private long getCount(int[] inv, long price) {
        long count = 0;
        for (int i : inv) {
            count += Math.max(0, i - price + 1);
        }
        return count;
    }
}
