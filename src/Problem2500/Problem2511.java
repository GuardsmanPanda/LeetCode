package Problem2500;

public class Problem2511 {
    public int captureForts(int[] forts) {
        int lastOne = -1, lastMinusOne = -1, res = 0;
        for (int i = 0; i < forts.length; i++) {
            int n = forts[i];
            if (n == 1) {
                if (lastMinusOne != -1) {
                    res = Math.max(res, i - lastMinusOne - 1);
                }
                lastMinusOne = -1;
                lastOne = i;
            }
            if (n == -1) {
                if (lastOne != -1) {
                    res = Math.max(res, i - lastOne - 1);
                }
                lastMinusOne = i;
                lastOne = -1;
            }
        }
        return res;
    }
}
