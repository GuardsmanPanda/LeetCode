package Problem1400;

import java.util.stream.IntStream;

public class Problem1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        return (int)IntStream.range(0, startTime.length).filter(i -> startTime[i] <= queryTime && endTime[i] >= queryTime).count();
    }
}
