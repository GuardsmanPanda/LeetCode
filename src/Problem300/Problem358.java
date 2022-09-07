package Problem300;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Problem358 {
    public String rearrangeString(String s, int k) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        PriorityQueue<int[]> avail = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        ArrayDeque<int[]> wait = new ArrayDeque<>();
        for (int i = 'a'; i <= 'z'; i++) {
            if (count[i] > 0) {
                avail.add(new int[]{i, 0, count[i]});
            }
        }
        StringBuilder result = new StringBuilder();
        while (avail.size() > 0 || wait.size() > 0) {
            while (wait.size() > 0 && wait.peekLast()[1] <= result.length()) {
                avail.add(wait.removeLast());
            }
            if (avail.size() == 0) {
                return "";
            }
            int[] node = avail.poll();
            node[1] = k + result.length();
            result.appendCodePoint(node[0]);
            if (--node[2] > 0) {
                wait.addFirst(node);
            }
        }
        return result.toString();
    }
}
