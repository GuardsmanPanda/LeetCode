package Problem2400;

public class Problem2447 {
    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            for (int j = i; j < nums.length; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == k) {
                    res++;
                }
                if (gcd < k) {
                    break;
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
