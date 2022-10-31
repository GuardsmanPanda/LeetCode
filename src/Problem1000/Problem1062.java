package Problem1000;

import java.util.HashSet;

public class Problem1062 {
    public int longestRepeatingSubstring(String s) {
        int low = 0, high = s.length() - 1;
        char[] chars = s.toCharArray();
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (repeats(chars, mid - 1)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean repeats(char[] a, int len) {
        HashSet<Long> seen = new HashSet<>();
        long hash = 0, prime = 999999999989L, multiplier = 1;
        for (int i = 0; i < a.length; i++) {
            hash = (hash * 26 + a[i] - 'a') % prime;
            if (i >= len) {
                if (!seen.add(hash)) {
                    return true;
                }
                hash = (hash - multiplier * (a[i - len] - 'a')) % prime + prime;
            } else {
                multiplier = (multiplier * 26) % prime;
            }
        }
        return false;
    }
}
