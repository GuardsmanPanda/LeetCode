package Special;

public class MRUQueue {
    private final int[] queue;

    public MRUQueue(int n) {
        queue = new int[n + 1];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = i;
        }
    }

    public int fetch(int k) {
        int res = queue[k];
        for (int i = k; i < queue.length - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[queue.length - 1] = res;
        return res;
    }
}
