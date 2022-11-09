package Problem1400;

public class Problem1409 {
    public int[] processQueries(int[] queries, int m) {
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i + 1;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = 0;
            while (p[index] != queries[i]) {
                index++;
            }
            result[i] = index;
            int temp = p[index];
            System.arraycopy(p, 0, p, 1, index);
            p[0] = temp;
        }
        return result;
    }
}
