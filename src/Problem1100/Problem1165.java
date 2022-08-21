package Problem1100;

public class Problem1165 {
    public int calculateTime(String keyboard, String word) {
        int lastIdx = 0;
        int res = 0;
        for (char c : word.toCharArray()) {
            int idx = keyboard.indexOf(c);
            res += Math.abs(idx - lastIdx);
            lastIdx = idx;
        }
        return res;
    }
}
