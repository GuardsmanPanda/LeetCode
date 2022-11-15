package Problem;

public class Problem91 {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        char[] ca = s.toCharArray();
        int[] ways = new int[ca.length + 1];
        ways[0] = 1;

        char prev = '0';
        for (int i = 0; i < ca.length; i++) {
            char next = ca[i];
            if (next > '0') ways[i + 1] = ways[i];
            if (i > 0 && prev == '1' || (prev == '2' && next <= '6')) ways[i + 1] += ways[i - 1];
            prev = next;
        }
        return ways[ca.length];
    }
}
