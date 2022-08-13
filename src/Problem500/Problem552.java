package Problem500;

import java.util.Arrays;

public class Problem552 {
    public int checkRecord(int n) {
        int mod = 1000000007;
        long[][] mat = {
                {1,1,0,1,0,0},
                {1,0,1,1,0,0},
                {1,0,0,1,0,0},
                {0,0,0,1,1,0},
                {0,0,0,1,0,1},
                {0,0,0,1,0,0}
        };
        mat = matExp(mat, 1, mod);
        long sum = 0;
        for (long l : mat[0]) {
            sum += l;
        }
        return (int) (sum % mod);
    }

    public long[][] matExp(long[][] mat, int n, int mod) {
        long[][] res = new long[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if (n % 2 == 1) {
                res = matMul(res, mat, mod);
            }
            mat = matMul(mat, mat, mod);
            n /= 2;
            System.out.println(n);
            System.out.println(Arrays.deepToString(res));
            System.out.println(Arrays.deepToString(mat));
        }
        return res;
    }

    public long[][] matMul(long[][] a, long[][] b, int mod) {
        long[][] res = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                    res[i][j] %= mod;
                }
            }
        }
        return res;
    }
}
