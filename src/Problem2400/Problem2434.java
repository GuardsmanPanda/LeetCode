package Problem2400;

import java.util.ArrayDeque;

public class Problem2434 {
    public String robotWithString(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        char[] a = s.toCharArray();
        int idx = 0;
        while (idx < a.length) {
            int lowest = 'z';
            int pos = 0;
            for (int i = idx; i < a.length; i++) {
                lowest = Math.min(lowest, a[i]);
                if (a[i] == lowest) {
                    pos = i;
                }
            }
            while (stack.size() > 0 && stack.peekLast() <= lowest) {
                res.append(stack.removeLast());
            }
            for (; idx <= pos; idx++) {
                if (a[idx] == lowest) {
                    res.append(a[idx]);
                } else {
                    stack.addLast(a[idx]);
                }
            }
        }
        while (stack.size() > 0) {
            res.append(stack.removeLast());
        }
        return res.toString();
    }
}
