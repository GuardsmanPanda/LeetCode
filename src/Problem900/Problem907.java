package Problem900;

import java.util.ArrayDeque;

public class Problem907 {
    public int sumSubarrayMins(int[] A) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.addFirst(new int[] {Integer.MIN_VALUE, -1});
        int[] preLen = new int[A.length];
        long result = 0, MOD = 1000000007;
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            while (stack.peekFirst()[0] >= val) stack.removeFirst();
            preLen[i] = i-stack.peekFirst()[1];
            stack.addFirst(new int[] {val, i});
        }
        stack.clear();
        stack.addFirst(new int[] {Integer.MIN_VALUE, A.length});
        for (int i = A.length - 1; i >= 0; i--) {
            int val = A[i];
            while (stack.peekFirst()[0] > val) stack.removeFirst();
            long postLen = stack.peekFirst()[1]-i;
            result = (result + postLen*preLen[i]*val) % MOD;
            stack.addFirst(new int[] {val, i});
        }
        return (int)result;
    }
}
