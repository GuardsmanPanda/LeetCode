import java.util.Arrays;

public class Problem2345 {
    public int visibleMountains(int[][] peaks) {
        boolean[] hidden = new boolean[peaks.length];
        Arrays.sort(peaks, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int curPeak = -1, lastPeak = -1;
        for (int i = 0; i < peaks.length; i++) {
            int x = peaks[i][0], y = peaks[i][1];
            curPeak -= x - lastPeak;
            lastPeak = x;
            if (curPeak < y) {
                curPeak = y;
            } else {
                hidden[i] = true;
            }
        }
        curPeak = -1;
        lastPeak = peaks[peaks.length - 1][0];
        for (int i = peaks.length - 1; i >= 0; i--) {
            int x = peaks[i][0], y = peaks[i][1];
            curPeak -= lastPeak - x;
            lastPeak = x;
            if (curPeak < y) {
                curPeak = y;
            } else {
                hidden[i] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < peaks.length; i++) {
            if (!hidden[i]) {
                count++;
            }
        }
        return count;
    }
}
