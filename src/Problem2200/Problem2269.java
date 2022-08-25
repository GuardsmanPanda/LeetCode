package Problem2200;

public class Problem2269 {
    public int divisorSubstrings(int num, int k) {
        char[] nums = Integer.toString(num).toCharArray();
        int val = 0, mod = 1;
        for (int i = 0; i < k - 1; i++) {
            val = val * 10 + nums[i] - '0';
            mod = mod * 10;
        }
        int count = 0;
        for (int i = k - 1; i < nums.length; i++) {
            val = val * 10 + nums[i] - '0';
            if (val > 0 && num % val == 0) {
                count++;
            }
            val = val % mod;
        }
        return count;
    }
}
