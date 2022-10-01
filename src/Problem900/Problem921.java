package Problem900;

public class Problem921 {
    public int minAddToMakeValid(String s) {
        int res = 0, count = 0;
        for (char c : s.toCharArray()) {
            count += 1 - ((c & 1) << 1);
            if (count < 0) {
                count++;
                res++;
            }
        }
        return res + count;
    }
}
