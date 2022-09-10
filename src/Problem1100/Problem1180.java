package Problem1100;

public class Problem1180 {
    public int countLetters(String s) {
        int res = 0, count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                res += count * (count + 1) / 2;
                count = 1;
            }
        }
        res += count * (count + 1) / 2;
        return res;
    }
}
