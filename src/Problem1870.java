public class Problem1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 > hour) {
            return -1;
        }
        int low = 1, high = 1_000_000_000;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            if (works(dist, speed, hour)) {
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return low;
    }

    private boolean works(int[] dist, int speed, double hour) {
        double sum = 0;
        for (int i = 0; i < dist.length; i++) {
            double time = (double)dist[i] / speed;
            sum += i < dist.length - 1 ? Math.ceil(time) : time;
        }
        return sum <=  hour;
    }
}
