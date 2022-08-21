package Problem1200;

import java.util.HashMap;

public class Problem1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int x : arr) {
            count[x + 1000]++;
        }
        boolean[] seen = new boolean[2001];
        for (int x : count) {
            if (x > 0 && seen[x]) return false;
            seen[x] = true;
        }
        return true;
    }
}
