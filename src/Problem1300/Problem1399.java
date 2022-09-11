package Problem1300;

public class Problem1399 {
    public int countLargestGroup(int n) {
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            count[getSum(i)]++;
        }
        int max = 0;
        int result = 0;
        for (int j : count) {
            if (j > max) {
                max = j;
                result = 1;
            } else if (j == max) {
                result++;
            }
        }
        return result;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
