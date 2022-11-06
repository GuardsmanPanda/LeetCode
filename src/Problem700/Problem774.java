package Problem700;

public class Problem774 {
    public double minmaxGasDist(int[] stations, int k) {
        double low = 0, high = 1e8;
        while (high - low > 1e-6) {
            double mid = (high - low) / 2 + low;
            if (possible(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    private boolean possible(int[] stations, int k, double d) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            count += (int) ((stations[i + 1] - stations[i]) / d);
        }
        return count <= k;
    }
}
