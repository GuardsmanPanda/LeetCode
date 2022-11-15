package Problem2400;

public class Problem2470 {
    public int subarrayLCM(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int lcm = nums[i];
            for (int j = i; j < nums.length; j++) {
                int gcd = gcd(lcm, nums[j]);
                lcm *= nums[j];
                lcm /= gcd;
                if (lcm == k) {
                    res++;
                }
                if (lcm > k) {
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
