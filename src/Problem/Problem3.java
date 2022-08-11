package Problem;

import java.util.ArrayDeque;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] contains = new boolean[128];
        ArrayDeque<Character> queue = new ArrayDeque<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            queue.addLast(c);
            if (contains[c]) {
                char popped = queue.removeFirst();
                while (popped != c) {
                    contains[popped] = false;
                    popped = queue.removeFirst();
                }
            } else {
                contains[c] = true;
                max = Math.max(max, queue.size());
            }
        }
        return max;
    }
}
