package Problem2400;

public class Problem2436 {
    public int minimumSplits(int[] nums) {
        int cur = 0, result = 1;
        for (int num : nums) {
            cur = gcd(num, cur);
            if (cur == 1) {
                result++;
                cur = num;
            }
        }
        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
