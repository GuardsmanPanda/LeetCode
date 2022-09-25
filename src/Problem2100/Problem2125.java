package Problem2100;

public class Problem2125 {
    public int numberOfBeams(String[] bank) {
        int res = 0, last = 0;
        for (String s : bank) {
            int ones = (int)s.chars().filter(c -> c == '1').count();
            if (ones > 0) {
                res += ones * last;
                last = ones;
            }
        }
        return res;
    }
}
