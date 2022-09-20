package Problem;

import Types.ListNode;

public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int listLength = 0;
        ListNode node = head;
        while (node != null) {
            listLength++;
            node = node.next;
        }
        k = k % listLength;
        if (k == 0) return head;

        ListNode newStart = null;
        int target = listLength - k;
        node = head;
        while (node.next != null) {
            target--;
            if (target == 0) {
                newStart = node.next;
                ListNode tmp = node.next;
                node.next = null;
                node = tmp;
            } else node = node.next;
        }
        node.next = head;
        return newStart;
    }
}
