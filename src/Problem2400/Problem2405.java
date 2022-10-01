package Problem2400;

public class Problem2405 {
    public int partitionString(String s) {
        int res = 1;
        boolean[] found = new boolean[26];
        for (char c : s.toCharArray()) {
            if (found[c - 'a']) {
                found = new boolean[26];
                res++;
            }
            found[c - 'a'] = true;
        }
        return res;
    }
}
