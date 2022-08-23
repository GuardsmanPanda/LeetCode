package Problem2300;

public class Problem2315 {
    public int countAsterisks(String s) {
        boolean count = true;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                count = !count;
            }
            if (count && c == '*') {
                res++;
            }
        }
        return res;
    }
}
