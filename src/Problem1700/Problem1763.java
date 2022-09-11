package Problem1700;

public class Problem1763 {
    public String longestNiceSubstring(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + res.length() + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (sub.length() > res.length() && isNice(sub)) {
                    res = sub;
                }
            }
        }
        return res;
    }

    private boolean isNice(String s) {
        int[] cnt = new int[128];
        s.chars().forEach(c -> cnt[c]++);
        for (char i = 'a'; i <='z'; i++) {
            if (cnt[i] * cnt[i - 32] == 0 && cnt[i] + cnt[i - 32] > 0) {
                return false;
            }
        }
        return true;
    }
}
