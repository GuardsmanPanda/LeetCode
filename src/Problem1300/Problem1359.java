package Problem1300;

public class Problem1359 {
    public int countOrders(int n) {
        long mod = 1000000007;
        long res = 1;
        for (int i = 0, cnt = 1; i < n; i++) {
            res *= cnt++;
            res *= cnt++;
            res /= 2;
            res %= mod;
        }
        return (int) res;
    }
}
