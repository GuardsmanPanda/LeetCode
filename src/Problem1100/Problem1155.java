package Problem1100;

public class Problem1155 {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1_000_000_007;
        int[] cur = new int[target + 1];
        cur[0] = 1;
        for (int i = 0; i < n; i++) {
            int[] next = new int[target + 1];
            for (int j = 0; j < cur.length; j++) {
                for (int val = 1; val <= k; val++) {
                    if (j + val <= target) {
                        next[j + val] += cur[j];
                        next[j + val] %= mod;
                    }
                }
            }
            cur = next;
        }
        return cur[target];
    }
}
