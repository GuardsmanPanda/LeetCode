package Problem2400;

public class Problem2438 {
    public int[] productQueries(int n, int[][] queries) {
        long[] pow = new long[Integer.bitCount(n)];
        int mod = 1_000_000_007;
        for (int i = 0, idx = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                pow[idx++] = 1L << i;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long tmp = 1;
            for (int k = queries[i][0]; k <= queries[i][1]; k++) {
                tmp = (tmp * pow[k]) % mod;
            }
            res[i] = (int) tmp;
        }
        return res;
    }
}
