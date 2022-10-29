package Problem2300;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2323 {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(workers);
        Arrays.sort(jobs);
        return IntStream.range(0, jobs.length)
                .map(i -> (jobs[i] + workers[i] - 1) / workers[i])
                .max().orElse(-1);
    }
}
