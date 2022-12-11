package Problem200;

import java.util.ArrayList;
import java.util.List;

public class Problem282 {
    public List<String> addOperators(String num, int target) {
        return solve(num, new StringBuilder(), 0, 0, target, new ArrayList<>(), 0);
    }

    private List<String> solve(String num, StringBuilder tmp, int idx, long val, long target, List<String> result, long mulChain) {
        if (idx == num.length()) {
            if (val == target) {
                result.add(tmp.toString());
            }
            return result;
        }
        for (int i = idx; i < num.length(); i++) {
            if (i != idx && num.charAt(idx) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(idx, i + 1));
            int len = tmp.length();
            if (idx == 0) {
                tmp.append(cur);
                solve(num, tmp, i + 1, cur, target, result, cur);
                tmp.setLength(len);
            } else {
                tmp.append('+').append(cur);
                solve(num, tmp, i + 1, val + cur, target, result, cur);
                tmp.setLength(len);
                tmp.append('-').append(cur);
                solve(num, tmp, i + 1, val - cur, target, result, -cur);
                tmp.setLength(len);
                tmp.append('*').append(cur);
                solve(num, tmp, i + 1, val + mulChain * cur - mulChain, target, result, mulChain * cur);
                tmp.setLength(len);
            }
        }
        return result;
    }
}
