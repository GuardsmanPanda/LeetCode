package Problem;

public class Problem28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        char[] hay = haystack.toCharArray(), need = needle.toCharArray();
        int n = haystack.length() - needle.length() + 1;
        for (int i = 0; i < n; i++) {
            int hitCount = 0;
            while (hay[i + hitCount] == need[hitCount]) {
                hitCount++;
                if (hitCount == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
