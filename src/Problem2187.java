public class Problem2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long min = 0, max = Long.MAX_VALUE;
        while (min < max) {
            long mid = (max - min) / 2 + min;
            if (check(time, mid, totalTrips)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean check(int[] time, long mid, int totalTrips) {
        long count = 0;
        for (int tripLength : time) {
            count += mid / tripLength;
            if (count >= totalTrips) {
                return true;
            }
        }
        return count >= totalTrips;
    }
}
