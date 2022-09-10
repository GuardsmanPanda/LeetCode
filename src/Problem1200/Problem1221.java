package Problem1200;

public class Problem1221 {
    public int balancedStringSplit(String s) {
        int res = 0, balance = 0;
        for (char c : s.toCharArray()) {
            balance += (c & 0b10) - 1;
            res += balance == 0 ? 1 : 0;
        }
        return res;
    }
}
