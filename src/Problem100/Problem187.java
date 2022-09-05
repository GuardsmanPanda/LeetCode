package Problem100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String sub = s.substring(i-10, i);
            if (seen.contains(sub)) result.add(sub);
            else seen.add(sub);
        }
        return new ArrayList<>(result);
    }
}
