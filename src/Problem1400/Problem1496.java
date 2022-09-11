package Problem1400;

import java.util.HashSet;

public class Problem1496 {
    public boolean isPathCrossing(String path) {
        HashSet<String> seen = new HashSet<>();
        int x = 0, y = 0;
        seen.add(x + "," + y);
        for (char c : path.toCharArray()) {
            x += c == 'N' ? 1 : c == 'S' ? -1 : 0;
            y += c == 'E' ? 1 : c == 'W' ? -1 : 0;
            if (!seen.add(x + "," + y)) {
                return true;
            }
        }
        return false;
    }
}
