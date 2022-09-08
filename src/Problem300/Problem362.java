package Problem300;

import java.util.ArrayDeque;

public class Problem362 {
    private final ArrayDeque<Integer> hits = new ArrayDeque<>();

    public void hit(int timestamp) {
        hits.addLast(timestamp);
        while (hits.getFirst() <= timestamp - 300) {
            hits.removeFirst();
        }
    }

    public int getHits(int timestamp) {
        while (hits.size() > 0 && hits.getFirst() <= timestamp - 300) {
            hits.removeFirst();
        }
        return hits.size();
    }
}
