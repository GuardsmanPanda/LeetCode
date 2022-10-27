package Problem1100;

public class Problem1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > 26 || s.length() < k) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int[] found = new int[128];
        int blockers = 0, res = 0, x = -1;
        while (++x < k - 1) {
            if (found[arr[x]]++ >= 1) {
                blockers++;
            }
        }
        for (int i = k - 1; i < s.length(); i++) {
            if (found[arr[i]]++ >= 1) {
                blockers++;
            }
            if (blockers == 0) {
                res++;
            }
            if (found[arr[i - k + 1]]-- >= 2) {
                blockers--;
            }
        }
        return res;
    }
}
