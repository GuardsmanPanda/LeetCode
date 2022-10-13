package Problem2400;

public class Problem2432 {
    public int hardestWorker(int n, int[][] logs) {
        int result = 0, cur = 0, max = 0;
        for (int[] log : logs) {
            if (log[1] - cur > max || (log[1] - cur == max && log[0] < result)) {
                max = log[1] - cur;
                result = log[0];
            }
            cur = log[1];
        }
        return result;
    }
}
