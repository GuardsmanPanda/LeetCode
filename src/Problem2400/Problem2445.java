package Problem2400;

public class Problem2445 {
    public int numberOfNodes(int n, int[] queries) {
        boolean[] flipped = new boolean[n + 1];
        for (int q : queries) {
            flipped[q] = !flipped[q];
        }
        return getFlipped(flipped, 1, false);
    }

    private int getFlipped(boolean[] flipped, int i, boolean isFlipped) {
        if (i >= flipped.length) {
            return 0;
        }
        isFlipped ^= flipped[i];
        return (isFlipped ? 1 : 0) + getFlipped(flipped, i * 2, isFlipped) + getFlipped(flipped, i * 2 + 1, isFlipped);
    }
}
