package Problem1300;

public class Problem1304 {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = n % 2 == 0 ? 0 : 1; i < n; i += 2) {
            res[i] = i + 1;
            res[i + 1] = -i - 1;
        }
        return res;
    }
}
