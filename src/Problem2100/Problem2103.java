package Problem2100;

import java.util.stream.IntStream;

public class Problem2103 {
    public int countPoints(String rings) {
        boolean[] b = new boolean[10];
        boolean[] r = new boolean[10];
        boolean[] g = new boolean[10];
        for (int i = 0; i < rings.length(); i += 2) {
            char c = rings.charAt(i);
            int n = rings.charAt(i + 1) - '0';
            if (c == 'B') {
                b[n] = true;
            } else if (c == 'R') {
                r[n] = true;
            } else {
                g[n] = true;
            }
        }
        return IntStream.range(0, 10).map(i -> (b[i] && r[i] && g[i]? 1 : 0)).sum();
    }
}
