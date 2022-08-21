package Problem1100;

public class Problem1130 {
    public int mctFromLeafValues(int[] arr) {
        long[][] cost = new long[arr.length][arr.length];
        long[][] maxVal = new long[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            for (int j = i; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
                maxVal[i][j] = max;
            }
        }
        return (int) getMin(arr, 0, arr.length - 1, cost, maxVal);
    }

    private long getMin(int[] arr, int left, int right, long[][] cost, long[][] maxVal) {
        if (cost[left][right] != 0) {
            return cost[left][right];
        }
        if (left == right) {
            return 0;
        }
        if (left + 1 == right) {
            cost[left][right] = (long)arr[left] * arr[right];
            return cost[left][right];
        }
        cost[left][right] = Long.MAX_VALUE;
        for (int i = left + 1; i <= right; i++) {
            long curVal = maxVal[left][i - 1] * maxVal[i][right];
            cost[left][right] = Math.min(cost[left][right], getMin(arr, left, i - 1, cost, maxVal) + getMin(arr, i, right, cost, maxVal) + curVal);
        }
        return cost[left][right];
    }
}
