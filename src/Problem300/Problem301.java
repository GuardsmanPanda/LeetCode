package Problem300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem301 {
    private final Set<String> result = new HashSet<>();
    private final Set<String> seen = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        solve(s);
        return new ArrayList<>(result);
    }

    private void solve(String s) {
        if (!seen.add(s)) {
            return;
        }
        boolean ok = true;
        List<Integer> closing = new ArrayList<>();
        for (int i = 0, count = 0; i < s.length() && ok; i++) {
            char c = s.charAt(i);
            count += c == '(' ? 1 : c == ')' ? -1 : 0;
            if (c == ')') {
                closing.add(i);
            }
            if (count < 0) {
                ok = false;
                for (Integer idx : closing) {
                    solve(s.substring(0, idx) + s.substring(idx + 1));
                }
            }
        }
        List<Integer> opening = new ArrayList<>();
        for (int i = s.length() - 1, count = 0; i >= 0 && ok; i--) {
            char c = s.charAt(i);
            count += c == ')' ? 1 : c == '(' ? -1 : 0;
            if (c == '(') {
                opening.add(i);
            }
            if (count < 0) {
                ok = false;
                for (Integer idx : opening) {
                    solve(s.substring(0, idx) + s.substring(idx + 1));
                }
            }
        }
        if (ok) {
            result.add(s);
        }
    }
}
