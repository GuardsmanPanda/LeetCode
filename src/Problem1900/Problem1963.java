package Problem1900;

public class Problem1963 {
    public int minSwaps(String s) {
        int cur = 0, res = 0;
        for (char c : s.toCharArray()) {
            cur += 2 - (c & 0b11);
            res = Math.min(res, cur);
        }
        return -++res / 2;
    }
}
