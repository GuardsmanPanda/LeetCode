package Problem2300;

import java.util.Arrays;

public class Problem2327 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] knows = new int[n + 1];
        int mod = 1000000007;
        long share = 0;
        knows[1] = 1;
        for (int i = 2; i <= n; i++) {
            share += knows[Math.max(0, i - delay)] + mod;
            share -= knows[Math.max(0, i - forget)];
            share %= mod;
            knows[i] = (int)share;
        }
        int res = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            res += knows[i];
            res %= mod;
        }
        return res;
    }
}
