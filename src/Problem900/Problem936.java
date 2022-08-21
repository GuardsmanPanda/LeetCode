package Problem900;

import java.util.ArrayDeque;

public class Problem936 {
    public int[] movesToStamp(String stamp, String target) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        char[] tar = target.toCharArray();
        tryStamp(stamp.toCharArray(), tar, q);
        for (char c : tar) {
            if (c != '?') {
                return new int[0];
            }
        }
        int[] res = new int[q.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = q.removeLast();
        }
        return res;
    }

    private void tryStamp(char[] stamp, char[] target, ArrayDeque<Integer> stack) {
        boolean found = false;
        for (int i = 0; i <= target.length - stamp.length; i++) {
            boolean match = false;
            for (int k = 0; k < stamp.length; k++) {
                if (target[i + k] == stamp[k]) {
                    match = true;
                } else if (target[i + k] != '?') {
                    match = false;
                    break;
                }
            }
            if (match) {
                found = true;
                stack.addLast(i);
                for (int j = 0; j < stamp.length; j++) {
                    target[i + j] = '?';
                }
            }
        }
        if (!found) {
            return;
        }
        tryStamp(stamp, target, stack);
    }
}
