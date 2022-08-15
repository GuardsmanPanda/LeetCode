package Problem1400;

import java.util.ArrayDeque;

public class Problem1414 {
    public int findMinFibonacciNumbers(int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int last = 1, cur = 1;
        stack.add(1);
        while (cur < k) {
            int next = last + cur;
            stack.addFirst(next);
            last = cur;
            cur = next;
        }
        int res = 0;
        while (k > 0) {
            int number = stack.removeFirst();
            if (number <= k) {
                k -= number;
                res++;
            }
        }
        return res;
    }
}
