package Problem2100;

public class Problem2180 {
    public int countEven(int num) {
        int res = 0;
        while (num > 0) {
            int n = num--;
            int tmp = 0;
            while (n > 0) {
                tmp += n % 10;
                n /= 10;
            }
            if (tmp % 2 == 0) res++;
        }
        return res;
    }
}
