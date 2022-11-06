package Problem1300;

import java.util.Arrays;

public class Problem1349 {
    public int maxStudents(char[][] seats) {
        int len = 1 << seats[0].length;
        int[] last = new int[len];
        for (char[] row : seats) {
            int[] cur = new int[len];
            for (int i = 0; i < len; i++) {
                if (fail(i, row)) {
                    continue;
                }
                int cnt = Integer.bitCount(i);
                for (int j = 0; j < len; j++) {
                    if ((i << 1 & j) == 0 && (i >> 1 & j) == 0) {
                        cur[i] = Math.max(cur[i], last[j] + cnt);
                    }
                }
            }
            last = cur;
        }
        return Arrays.stream(last).max().orElse(0);
    }

    private boolean fail(int i, char[] row) {
        if ((i & (i >> 1)) != 0 || (i & (i << 1)) != 0) {
            return true;
        }
        for (int j = 0; j < row.length; j++) {
            if (row[j] == '#' && ((i >> j) & 1) == 1) {
                return true;
            }
        }
        return false;
    }
}
