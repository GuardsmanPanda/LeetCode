package Problem2100;

import Types.ListNode;

import java.util.ArrayDeque;

public class Problem2130 {
    public int pairSum(ListNode head) {
        ListNode current = head;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (current != null) {
            stack.addFirst(current.val);
            current = current.next;
        }
        int max = 0;
        while (stack.size() > 0) {
            max = Math.max(head.val + stack.removeFirst(), max);
            head = head.next;
        }
        return max;
    }
}
