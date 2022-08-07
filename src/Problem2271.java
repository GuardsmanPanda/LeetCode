import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class Problem2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        if (tiles == null || tiles.length == 0 || carpetLen == 0) {
            return 0;
        }
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int res = 0, sizeInQueue = 0;
        ArrayDeque<int[]> tq = new ArrayDeque<>();
        for (int[] tile : tiles) {
            tq.addFirst(tile);
            sizeInQueue += tile[1] - tile[0] + 1;
            while (tile[1] - tq.peekLast()[1] >= carpetLen) {
                int[] item = tq.removeLast();
                sizeInQueue -= item[1] - item[0] + 1;
            }
            int[] last = tq.peekLast();
            int carpetLeft = tile[1] - carpetLen + 1;
            int uncovered = Math.max(0, carpetLeft - last[0]);
            res = Math.max(res, sizeInQueue - uncovered);
        }
        return res;
    }
}
