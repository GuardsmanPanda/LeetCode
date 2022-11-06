package Problem1500;

import Types.ArrayReader;

public class Problem1533 {
    public int getIndex(ArrayReader reader) {
        int low = 0, high = reader.length() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if ((high - low) % 2 == 0) {
                int cmp = reader.compareSub(low, mid - 1, mid + 1, high);
                if (cmp == 0) {
                    return mid;
                } else if (cmp == 1) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                int cmp = reader.compareSub(low, mid, mid + 1, high);
                 if (cmp == 1) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return low;
    }
}
