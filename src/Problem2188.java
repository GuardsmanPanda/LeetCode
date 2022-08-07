import java.util.Arrays;

public class Problem2188 {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        long[] lapTimes = new long[numLaps + 1];
        Arrays.fill(lapTimes, Integer.MAX_VALUE);
        for (int[] tire : tires) {
            long lapTime = 0;
            for (int i = 0; i < numLaps; i++) {
                lapTime += tire[0] * (long)Math.pow(tire[1], i);
                if (lapTime > Integer.MAX_VALUE) {
                    break;
                }
                //System.out.println("tire: " + tire[0] + " " + tire[1] + ", i: " + i + ", lapTime: " + lapTime);
                lapTimes[i + 1] = Math.min(lapTimes[i + 1], lapTime);
            }
        }
        System.out.println(Arrays.toString(lapTimes));
        long[] raceTime = new long[numLaps + 1];
        Arrays.fill(raceTime, Integer.MAX_VALUE);
        raceTime[0] = -changeTime;
        for (int i = 1; i <= numLaps; i++) {
            for (int k = 0; k < i; k++) {
                raceTime[i] = Math.min(raceTime[i], raceTime[k] + changeTime + lapTimes[i - k]);
            }
        }
        System.out.println(Arrays.toString(raceTime));
        return (int)raceTime[numLaps];
    }
}
