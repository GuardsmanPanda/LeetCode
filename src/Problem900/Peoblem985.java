package Problem900;

public class Peoblem985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int i : A) if (i % 2 == 0) sum += i;
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], idx = queries[i][1];
            if (A[idx] % 2 == 0) {
                if (val % 2 == 0) sum += val;
                else sum -= A[idx];
            } else if (val % 2 != 0) sum += A[idx]+val;
            A[idx] += val;
            res[i] = sum;
        }
        return res;
    }
}
