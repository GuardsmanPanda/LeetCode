public class Problem1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay == null || m * k > bloomDay.length) {
            return -1;
        }
        int low = 1, high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (works(bloomDay, mid, m, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean works(int[] bloom, int time, int m, int k) {
        int count = 0;
        for (int i = 0; i < bloom.length;) {
            int streak = 0;
            while (streak < k && i < bloom.length) {
                if (bloom[i++] <= time) {
                    streak++;
                } else {
                    break;
                }
            }
            if (streak >= k) {
                count++;
            }
        }
        return count >= m;
    }
}
