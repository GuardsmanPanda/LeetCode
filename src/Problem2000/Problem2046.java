package Problem2000;

import Types.ListNode;

import java.util.ArrayDeque;

public class Problem2046 {
    public ListNode sortLinkedList(ListNode head) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            if (node.val < 0) {
                deque.addFirst(node.val);
            } else {
                deque.addLast(node.val);
            }
            node = node.next;
        }
        node = head;
        while (node != null) {
            node.val = deque.removeFirst();
            node = node.next;
        }
        return head;
    }
}
