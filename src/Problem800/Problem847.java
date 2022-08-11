package Problem800;

public class Problem847 {
    public int shortestPathLength(int[][] graph) {
        if (graph == null || graph.length < 2) return 0;
        boolean[] seen = new boolean[1 << (graph.length + 4)];
        MyCircularQueue queue = new MyCircularQueue(1000);
        for (int i = 0; i < graph.length; i++) {
            int state = (1 << i) + (i << graph.length);
            queue.enQueue(state);
            seen[state] = true;
        }
        int steps = 0, frontier = queue.size();
        while (!queue.isEmpty()) {
            int state = queue.deQueue();
            int node = state >> graph.length;
            int visMask = state & ((1 << graph.length) - 1);
            //System.out.println("step: " + steps+ ", state: " + Integer.toBinaryString(state) + ", node: " + node + ", vismask: " + Integer.toBinaryString(visMask));
            if (visMask == (1 << graph.length) - 1) {
                return steps;
            }
            for (int adj : graph[node]) {
                int newState = (visMask | (1 << adj)) + (adj << graph.length);
                if (seen[newState]) continue;
                seen[newState] = true;
                queue.enQueue(newState);
            }
            if (--frontier == 0) {
                frontier = queue.size();
                steps++;
            }
        }
        return 0;
    }

    static class MyCircularQueue {
        int[] values;
        int head = 0, tail = 1, size = 0, cap;

        public MyCircularQueue(int k) {
            if (k == 1) tail = 0;
            cap = k;
            values = new int[k];
        }

        public boolean enQueue(int value) {
            if (size == cap) return false;
            values[head = (head + 1) % cap] = value;
            size++;
            return true;
        }

        public int deQueue() {
            int val = values[tail];
            tail = (tail + 1) % cap;
            size--;
            return val;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }
}
