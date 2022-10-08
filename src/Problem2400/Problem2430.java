package Problem2400;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2430 {
    public int deleteString(String s) {
        int[] state = new int[s.length() + 1];
        Arrays.fill(state, Integer.MIN_VALUE);
        state[0] = 0;
        return IntStream.range(0, s.length())
                .map(i -> getMaxOps(s, i, state) + 1)
                .max().orElse(-1);
    }

    private int getMaxOps(String s, int pos, int[] state) {
        System.out.println("pos: " + pos + ", state: " + state[pos]);
        if (state[pos] == Integer.MIN_VALUE) {
            long forwardHash = 0, backHash = 0, mul = 1;
            long mod = 799333555511111L;
            int steps = Math.min(pos, s.length() - pos);
            for (int i = 1; i <= steps; i++) {
                backHash = backHash * 137 + s.charAt(pos + i - 1);
                backHash %= mod;
                forwardHash += mul * s.charAt(pos - i);
                forwardHash %= mod;
                System.out.println("pos: " + pos + ", i: " + i + ", fh: " + forwardHash + ", bh: " +backHash);
                mul = (mul * 137) % mod;
                if (forwardHash == backHash) {
                    state[pos] = Math.max(state[pos], getMaxOps(s, pos - i, state) + 1);
                }
            }
        }
        return state[pos];
    }
}
