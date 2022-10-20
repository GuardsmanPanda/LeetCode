package Problem1000;

public class Problem1003 {
    public boolean isValid(String s) {
        int[] stack = new int[s.length()];
        int idx = 0;
        for (char c : s.toCharArray()) {
            stack[idx++] = c;
            if (idx > 2 && stack[idx - 1] == 'c' && stack[idx - 2] == 'b' && stack[idx - 3] == 'a') {
                idx -= 3;
            }
        }
        return idx == 0;
    }
}
