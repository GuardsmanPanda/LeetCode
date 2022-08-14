package Problem1000;

public class Problem1055 {
    public int shortestWay(String source, String target) {
        int[][] pos = new int[26][source.length() + 1];
        for (int i = 0; i < source.length(); i++) {
            int c = source.charAt(i) - 'a';
            int idx = i;
            while (idx >= 0 && pos[c][idx] == 0) {
                pos[c][idx--] = i + 1;
            }
        }
        int res = 1, idx = 0;
        for (char cc : target.toCharArray()) {
            int c = cc - 'a';
            if (pos[c][idx] == 0) {
                idx = 0;
                res++;
            }
            if (pos[c][idx] == 0) {
                return -1;
            }
            idx = pos[c][idx];
        }
        return res;
    }
}
