package Problem1700;

public class Problem1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int cur = 0;
        for (int j : gain) {
            cur += j;
            max = Math.max(max, cur);
        }
        return max;
    }
}
