package Problem1100;

public class Problem1198 {
    public int smallestCommonElement(int[][] mat) {
        int[] idx = new int[mat.length];
        int element = mat[0][0];
        int checked = 0, cur = 0;
        while (checked++ < mat.length) {
            cur = (cur + 1) % mat.length;
            while (idx[cur] < mat[cur].length && mat[cur][idx[cur]] < element) {
                idx[cur]++;
            }
            if (idx[cur] == mat[cur].length) {
                return -1;
            }
            if (mat[cur][idx[cur]] > element) {
                element = mat[cur][idx[cur]];
                checked = 0;
            }
        }
        return element;
    }
}
