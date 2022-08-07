public class Problem265 {
    public int minCostII(int[][] costs) {
        int [] last = new int[costs[0].length];
        int [] next = new int[costs[0].length];
        for (int[] cost : costs) {
            int minValue = last[0], minIndex = 0, secondMin = Integer.MAX_VALUE;
            for (int i = 1; i < last.length; i++) {
                if (last[i] < minValue) {
                    secondMin = minValue;
                    minValue = last[i];
                    minIndex = i;
                } else if (last[i] < secondMin) {
                    secondMin = last[i];
                }
            }
            for (int i = 0; i < next.length; i++) {
                next[i] = (i == minIndex ? secondMin : minValue) + cost[i];
            }
            int[] tmp = last;
            last = next;
            next = tmp;
        }
        int minValue = last[0];
        for (int i = 1; i < last.length; i++) {
            if (last[i] < minValue) {
                minValue = last[i];
            }
        }
        return minValue;
    }
}
