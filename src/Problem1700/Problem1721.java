package Problem1700;

import Types.ListNode;

import java.util.ArrayDeque;

public class Problem1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            stack.addFirst(node);
            node = node.next;
        }
        node = head;
        while (node != null) {
            ListNode other = stack.removeFirst();
            if (--k == 0) {
                int temp = node.val;
                node.val = other.val;
                other.val = temp;
                break;
            }
            node = node.next;
        }
        return head;
    }
}
