package Special;

import java.util.*;

public class MaxStack {
    private final ArrayDeque<int[]> stack = new ArrayDeque<>();
    private final PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
    private final HashSet<Integer> deleted = new HashSet<>();
    private int id = 0;

    public void push(int x) {
        int[] item = new int[]{x, id++};
        stack.addFirst(item);
        maxHeap.add(item);
    }

    public int pop() {
        int[] x = stack.removeFirst();
        while (deleted.contains(x[1])) {
            deleted.remove(x[1]);
            x = stack.removeFirst();
        }
        deleted.add(x[1]);
        return x[0];
    }

    public int top() {
        int[] x = stack.peekFirst();
        System.out.println(Arrays.toString(x));
        while (deleted.contains(x[1])) {
            stack.removeFirst();
            deleted.remove(x[1]);
            x = stack.peekFirst();
        }
        System.out.println(Arrays.toString(x));
        return x[0];
    }

    public int peekMax() {
        int[] x = maxHeap.peek();
        while (deleted.contains(x[1])) {
            maxHeap.remove();
            deleted.remove(x[1]);
            x = maxHeap.peek();
        }
        return x[0];
    }

    public int popMax() {
        int[] x = maxHeap.remove();
        while (deleted.contains(x[1])) {
            x = maxHeap.remove();
        }
        deleted.add(x[1]);
        System.out.println(deleted);
        return x[0];
    }
}
