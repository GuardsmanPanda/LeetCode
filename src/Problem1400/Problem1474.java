package Problem1400;

import Types.ListNode;

public class Problem1474 {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode node = head;
        while (node != null) {
            int m1 = m, n1 = n;
            while (m1-- > 1 && node != null) {
                node = node.next;
            }
            while (n1-- > 0 && node != null && node.next != null) {
                node.next = node.next.next;
            }
            if (node != null) {
                node = node.next;
            }
        }
        return head;
    }
}
