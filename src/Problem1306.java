public class Problem1306 {
    public boolean canReach(int[] arr, int start) {
        return findZero(start, arr, new boolean[arr.length]);
    }

    private boolean findZero(int idx, int[] arr, boolean[] vis) {
        if (vis[idx]) return false;
        if (arr[idx] == 0) return true;
        vis[idx] = true;
        if (idx + arr[idx] < arr.length && findZero(idx + arr[idx], arr, vis)) return true;
        return idx - arr[idx] >= 0 && findZero(idx - arr[idx], arr, vis);
    }
}
