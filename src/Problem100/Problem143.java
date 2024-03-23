package Problem100;

import Types.ListNode;

import java.util.ArrayDeque;

public class Problem143 {
    public void reorderList(ListNode head) {
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.addLast(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(0), cur = dummy;
        while (deque.size() >= 2) {
            cur.next = deque.removeFirst();
            cur.next.next = deque.removeLast();
            cur = cur.next.next;
        }
        if (deque.size() == 1) {
            cur.next = deque.removeFirst();
            cur = cur.next;
        }
        cur.next = null;
    }
}
