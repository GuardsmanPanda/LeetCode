package Problem1400;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> outGoing = new HashSet<>();
        for (List<String> path : paths) {
            outGoing.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!outGoing.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
