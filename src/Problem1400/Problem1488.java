package Problem1400;

import java.util.*;

public class Problem1488 {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> floodedMap = new HashMap<>();
        TreeSet<Integer> free = new TreeSet<>();
        int[] res = new int[rains.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                free.add(i);
            } else {
                res[i] = -1;
                Integer lastFlood = floodedMap.get(rains[i]);
                floodedMap.put(rains[i], i);
                if (lastFlood == null) {
                    continue;
                }
                Integer firstFree = free.ceiling(lastFlood);
                if (firstFree == null) {
                    return new int[]{};
                }
                res[firstFree] = rains[i];
                free.remove(firstFree);
            }
        }
        return res;
    }
}
