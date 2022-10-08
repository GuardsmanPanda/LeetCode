package Problem2400;

public class Problem2429 {
    public int minimizeXor(int num1, int num2) {
        int bits = Integer.bitCount(num2);
        int res = 0, idx = 31;
        while (bits > 0 && idx >= 0) {
            int bit = 1 << idx--;
            if ((num1 & bit) != 0) {
                res |= bit;
                bits--;
            }
        }
        while (bits > 0) {
            int bit = 1 << ++idx;
            if ((num1 & bit) == 0) {
                res |= bit;
                bits--;
            }
        }
        return res;
    }
}
