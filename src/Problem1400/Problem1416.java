package Problem1400;

import java.util.Arrays;

public class Problem1416 {
    public int numberOfArrays(String s, int k) {
        int left = 0, right = 0;
        long[] res = new long[s.length() + 1];
        long[] mul = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        long mod = 1000000007;
        long sum = 0;
        res[0] = 1;
        while (right < s.length()) {
            sum = sum * 10 + s.charAt(right++) - '0';
            while (sum > k || (left < right && s.charAt(left) == '0')) {
                sum -= (s.charAt(left++) - '0') * mul[right-left];
            }
          //  System.out.println("right = " + right + ", left = " + left + ", sum = " + sum);
            for (int i = left; i < right; i++) {
                if (s.charAt(i) != '0') {
                    res[right] += res[i];
                }
            }
            res[right] %= mod;
        }
      //  System.out.println(Arrays.toString(res));
        return (int) res[s.length()];
    }
}
