package Problem1600;

public class Problem1614 {
    public int maxDepth(String s) {
        int max = 0, depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                max = Math.max(max, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        return max;
    }
}
