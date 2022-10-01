package Problem2300;

public class Problem2375 {
    public String smallestNumber(String pattern) {
        return generate(pattern.toCharArray(), new char[pattern.length() + 1], 0, new boolean[10]);
    }

    private String generate(char[] pattern, char[] res, int idx, boolean[] used) {
        if (idx == res.length) {
            return new String(res);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (used[c - '1']) {
                continue;
            }
            if (idx > 0 && pattern[idx - 1] == 'D' && res[idx - 1] < c) {
                continue;
            }
            if (idx > 0 && pattern[idx - 1] == 'I' && res[idx - 1] > c) {
                continue;
            }
            used[c - '1'] = true;
            res[idx] = c;
            String tmp = generate(pattern, res, idx + 1, used);
            if (tmp != null) {
                return tmp;
            }
            used[c - '1'] = false;
        }
        return null;
    }
}
