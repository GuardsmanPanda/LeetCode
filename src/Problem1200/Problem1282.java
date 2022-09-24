package Problem1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> gm = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> list = gm.computeIfAbsent(size, k -> new ArrayList<>());
            list.add(i);
            if (list.size() == size) {
                gm.remove(size);
                res.add(list);
            }
        }
        return res;
    }
}
