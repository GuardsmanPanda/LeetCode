package Problem1700;

public class Problem1791 {
    public int findCenter(int[][] edges) {
        int[] a = edges[0];
        int[] b = edges[1];
        return a[0] == b[0] || a[0] == b[1] ? a[0] : a[1];
    }
}
