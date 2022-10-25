package Problem1800;

public class Problem1864 {

    public int minSwaps(String s) {
        int one = 0, zero = 0;
        for (char c : s.toCharArray()) {
            zero += 1 - (c & 1);
            one += c & 1;
        }
        if (Math.abs(zero - one) > 1) {
            return -1;
        }
        int startChar = zero > one ? 0 : 1;
        int res = 0;
        for (char c : s.toCharArray()) {
            res += startChar ^ (c & 1);
            startChar ^= 1;
        }
        return zero == one ? Math.min(res, s.length() - res) / 2 : res / 2;
    }
}
