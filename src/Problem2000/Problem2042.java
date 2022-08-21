package Problem2000;

import java.util.StringTokenizer;

public class Problem2042 {
    public boolean areNumbersAscending(String s) {
        int last = Integer.MIN_VALUE;
        for (String x : s.split("[^0-9]+")) {
            System.out.println(x);
            if (x.isEmpty()) continue;
            int cur = Integer.parseInt(x);
            if (cur <= last) return false;
            last = cur;
        }
        return true;
    }
}
