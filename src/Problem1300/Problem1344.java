package Problem1300;

public class Problem1344 {
    public double angleClock(int hour, int minutes) {
        double ma = minutes / 60d * 360d;
        double ha = hour / 12d * 360d + minutes / 60d * 30d;
        return Math.min(Math.abs(ma - ha), 360 - Math.abs(ma - ha));
    }
}
