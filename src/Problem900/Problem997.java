package Problem900;

public class Problem997 {
    public int findJudge(int N, int[][] trust) {
        int[] inc = new int[N+1], out = new int[N+1];
        for (int[] ints : trust) {
            inc[ints[1]]++;
            out[ints[0]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inc[i] == N-1 && out[i] == 0)
                return i;
        }
        return -1;
    }
}
