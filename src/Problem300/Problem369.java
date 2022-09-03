package Problem300;

import Types.ListNode;

import java.util.ArrayDeque;

public class Problem369 {
    public ListNode plusOne(ListNode head) {
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            stack.addFirst(node);
            node = node.next;
        }
        while (stack.size() > 0 && stack.peekFirst().val == 9) {
            stack.removeFirst().val = 0;
        }
        if (stack.size() == 0) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        stack.peekFirst().val++;
        return head;
    }
}
