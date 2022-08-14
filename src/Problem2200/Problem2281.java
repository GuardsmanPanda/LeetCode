package Problem2200;

import java.util.ArrayDeque;

public class Problem2281 {
    public int totalStrength(int[] strength) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int mod = 1000000007;
        long total = 0;
        long minMul = 0;
        for (int i : strength) {
            minMul += i;
            while (!stack.isEmpty() && stack.peekFirst() >= i) {
                int cur = stack.removeFirst();
                minMul -= cur - i;
            }
            stack.addFirst(i);
            total += minMul * i;
            total %= mod;
            System.out.println("i = " + i + ", sum = " + minMul + ", total = " + total);
        }
        return (int) total;
    }
}
