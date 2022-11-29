package Problem600;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Problem632 {
    record Pair(Integer x, String y) {}

    public int[] smallestRange(List<List<Integer>> nums) {
        TreeMap<Pair, List<Integer>> masterMap = new TreeMap<>(
                Comparator.comparingInt(Pair::x)
                        .thenComparing(Pair::y));
        boolean isDone = false;
        for (List<Integer> list : nums) {
            int number = list.remove(0);
            masterMap.put(new Pair(number, list.toString()), list);
        }
        int rangeBegin = 0;
        int rangeEnd = Integer.MAX_VALUE;

        while (!masterMap.isEmpty()) {
            int newBegin = masterMap.firstKey().x;
            int newEnd = masterMap.lastKey().x;
            if (rangeEnd-rangeBegin > newEnd - newBegin) {
                rangeBegin = newBegin;
                rangeEnd = newEnd;
            }
            List<Integer> currentList = masterMap.remove(masterMap.firstKey());
            if (currentList.isEmpty()) break;
            else {
                int number = currentList.remove(0);
                masterMap.put(new Pair(number, currentList.toString()), currentList);
            }
        }
        return new int[] {rangeBegin, rangeEnd};
    }
}
