package Problem900;

import java.util.Arrays;

public class Problem935 {
    public int knightDialer(int n) {
        if (n == 1) return 10;
        int mod = 1000000007;
        long[] numbers = new long[10];
        long[] next = new long[10];
        Arrays.fill(numbers, 1);
        numbers[5] = 0;
        for (int i = 1; i < n; i++) {
            next[0] = (numbers[4] + numbers[6]) % mod;
            next[1] = (numbers[6] + numbers[8]) % mod;
            next[2] = (numbers[7] + numbers[9]) % mod;
            next[3] = (numbers[4] + numbers[8]) % mod;
            next[4] = (numbers[3] + numbers[9] + numbers[0]) % mod;
            next[6] = (numbers[1] + numbers[7] + numbers[0]) % mod;
            next[7] = (numbers[2] + numbers[6]) % mod;
            next[8] = (numbers[1] + numbers[3]) % mod;
            next[9] = (numbers[2] + numbers[4]) % mod;
            long[] temp = numbers;
            numbers = next;
            next = temp;
        }
        return (int)(Arrays.stream(numbers).sum() % mod);
    }
}
