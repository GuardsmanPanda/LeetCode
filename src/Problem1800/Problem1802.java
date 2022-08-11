package Problem1800;

public class Problem1802 {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (test(n, index, mid, maxSum)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean test(int n, int index, int candidate, int maxSum) {
        //System.out.println("n: " + n + ", index: " + index + ", candidate: " + candidate + ", maxSum: " + maxSum);
        long res = candidate + getTriangleSum(index, candidate - 1) + getTriangleSum(n - index - 1, candidate - 1);
        //System.out.println("res: " + res);
        return res <= maxSum;
    }

    private long getTriangleSum(long length, long height) {
        if (height >= length) {
            return height * (height + 1) / 2 - (height - length) * (height - length + 1) / 2;
        }
        return height * (height + 1) / 2 + length - height;
    }
}
