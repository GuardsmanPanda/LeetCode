package Problem1200;

import java.util.*;

public class Problem1257 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parent = new HashMap<>();
        for (List<String> region : regions) {
            for (int i = 1; i < region.size(); i++) {
                parent.put(region.get(i), region.get(0));
            }
        }
        Set<String> found = new HashSet<>();
        while (region1 != null) {
            found.add(region1);
            region1 = parent.get(region1);
        }
        while (region2 != null) {
            if (found.contains(region2)) {
                return region2;
            }
            region2 = parent.get(region2);
        }
        return null;
    }
}
