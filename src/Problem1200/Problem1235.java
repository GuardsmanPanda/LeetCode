package Problem1200;

import java.util.*;

public class Problem1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new int[] {startTime[i], endTime[i], profit[i]});
        }
        jobs.sort(Comparator.comparingInt(a -> a[1]));
        TreeMap<Integer, Integer> profitMap = new TreeMap<>();
        for (int[] job : jobs) {
            var entry = profitMap.floorEntry(job[0]);
            int pr = (entry == null ? 0 : entry.getValue()) + job[2];
            var entry2 = profitMap.floorEntry(job[1]);
            if (entry2 != null && entry2.getValue() >= pr) {
                continue;
            }
            var entry3 = profitMap.ceilingEntry(job[1]);
            while (entry3 != null && entry3.getValue() <= pr) {
                profitMap.remove(entry3.getKey());
                entry3 = profitMap.ceilingEntry(job[1]);
            }
            profitMap.put(job[1], pr);
        }
        return profitMap.lastEntry().getValue();
    }
}
