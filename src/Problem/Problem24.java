package Problem;

import Types.ListNode;

public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode lastNode = dummyNode;
        while (lastNode.next != null && lastNode.next.next != null) {
            ListNode second = lastNode.next;
            ListNode first = second.next;
            ListNode after = first.next;
            lastNode.next = first;
            first.next = second;
            second.next = after;
            lastNode = second;
        }
        return dummyNode.next;
    }
}
