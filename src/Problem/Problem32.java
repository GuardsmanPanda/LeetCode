package Problem;

public class Problem32 {
    public int longestValidParentheses(String s) {
        int[] longestEnd = new int[s.length()+1];
        int[] stack = new int[s.length()];
        int longest = 0, idx = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack[++idx] = i;
            else if (idx >= 0) {
                int pos = stack[idx--];
                int cur = i-pos+1 + longestEnd[pos];
                longestEnd[i+1] = cur;
                longest = Math.max(longest, cur);
            }
        }
        return longest;
    }
}
