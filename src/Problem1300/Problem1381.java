package Problem1300;

public class Problem1381 {
    class CustomStack {
        private final int[] stack;
        private final int[] delta;
        private int idx = 1;

        public CustomStack(int maxSize) {
            stack = new int[maxSize + 2];
            delta = new int[maxSize + 2];
        }

        public void push(int x) {
            if (idx + 1 < stack.length) {
                stack[++idx] = x;
            }
        }

        public int pop() {
            int tmp = delta[idx];
            delta[idx - 1] += tmp;
            delta[idx] = 0;
            return idx == 1 ? -1 : tmp + stack[idx--];
        }

        public void increment(int k, int val) {
            delta[Math.min(k + 1, idx)] += val;
        }
    }
}
