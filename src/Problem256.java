public class Problem256 {
    public int minCost(int[][] costs) {
        int[] last = new int[3];
        int[] next = new int[3];
        for (int[] cost : costs) {
            next[0] = Math.min(last[1], last[2]) + cost[0];
            next[1] = Math.min(last[0], last[2]) + cost[1];
            next[2] = Math.min(last[1], last[0]) + cost[2];
            int[] tmp = last;
            last = next;
            next = tmp;
        }
        return Math.min(last[0], Math.min(last[1], last[2]));
    }
}
