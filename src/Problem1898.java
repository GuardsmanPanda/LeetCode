public class Problem1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] c1 = s.toCharArray();
        char[] c2 = p.toCharArray();
        int low = 0, high = removable.length;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (canRemove(c1, c2, removable, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean canRemove(char[] c1, char[] c2, int[] removable, int k) {
        boolean[] marked = new boolean[c1.length];
        for (int i = 0; i < k; i++) {
            marked[removable[i]] = true;
        }
        int idx1 = 0, idx2 = 0;
        while (idx1 < c1.length && idx2 < c2.length) {
            if (!marked[idx1] && c1[idx1] == c2[idx2]) {
                idx1++;
                idx2++;
            } else {
                idx1++;
            }
        }
        return idx2 == c2.length;
    }
}
