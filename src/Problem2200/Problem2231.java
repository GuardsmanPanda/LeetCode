package Problem2200;

public class Problem2231 {
    public int largestInteger(int num) {
        char[] a = Integer.toString(num).toCharArray();
        for (int i = 0; i < a.length - 1; i++) {
            char c = a[i];
            int idx = i;
            for (int k = a.length - 1; k > i; k--) {
                if (a[k] > a[idx] && a[i] % 2 == a[k] % 2) {
                    idx = k;
                }
            }
            if (idx != i) {
                char tmp = a[i];
                a[i] = a[idx];
                a[idx] = tmp;
            }
        }
        int res = 0;
        for (char c : a) {
            res *= 10;
            res += c - '0';
        }
        return res;
    }
}
