package Problem1200;

public class Problem1256 {
    public String encode(int num) {
        if (num == 0) {
            return "";
        }
        num++;
        int highBit = Integer.highestOneBit(num);
        num -= highBit;
        int len = -1;
        while (highBit > 0) {
            highBit >>= 1;
            len++;
        }
        String s = Integer.toBinaryString(num);
        return "0".repeat(len - s.length()) + s;
    }
}
