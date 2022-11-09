package Problem2300;

import java.util.Arrays;

public class Problem2350 {
    public int shortestSequence(int[] rolls, int k) {
        int[] nextPos = new int[rolls.length];
        int[] lastPos = new int[k + 1];
        Arrays.fill(nextPos, Integer.MAX_VALUE);
        Arrays.fill(lastPos, -1);
        int max = 0, foundCount = 0;
        for (int i = 0; i < rolls.length; i++) {
            int n = rolls[i];
            if (lastPos[n] == -1) {
                foundCount++;
                max = i;
            } else {
                nextPos[lastPos[n]] = i;
            }
            lastPos[n] = i;
        }
        if (foundCount < k) {
            return 1;
        }
        int idx = 0, len = 1;
        while (max != Integer.MAX_VALUE) {
            int newMax = 0;
            while (idx <= max) {
                newMax = Math.max(newMax, nextPos[idx]);
                idx++;
            }
            max = newMax;
            len++;
        }
        return len;
    }
}
