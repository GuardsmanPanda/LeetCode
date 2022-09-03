package Problem200;

import java.util.ArrayDeque;

public class Problem255 {
    public boolean verifyPreorder(int[] preorder) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int LastOut = Integer.MIN_VALUE;
        for (int i : preorder) {
            if (i <= LastOut)
                return false;
            while (stack.size() > 0 && i > stack.peekFirst())
                LastOut = stack.removeFirst();
            stack.addFirst(i);
        }
        return true;
    }
}
