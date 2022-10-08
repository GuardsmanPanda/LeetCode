package Problem1500;

public class Problem1578 {
    public int minCost(String colors, int[] neededTime) {
        char last = colors.charAt(0);
        int max = 0, res = 0;
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c != last) {
                last = c;
                res -= max;
                max = 0;
            }
            max = Math.max(max, neededTime[i]);
            res += neededTime[i];
        }
        return res - max;
    }
}
