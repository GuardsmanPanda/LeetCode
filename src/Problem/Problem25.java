package Problem;

import Types.ListNode;

public class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode lastNode = dummyNode, nextNode = lastNode;
        int counter = k;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
            counter--;
            if (counter == 0) {
                ListNode newLast = lastNode.next;
                lastNode.next = reverseUntil(lastNode.next, nextNode.next);
                lastNode = newLast;
                nextNode = newLast;
                counter = k;
            }
        }
        return dummyNode.next;
    }

    private ListNode reverseUntil(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode currentNode = start.next;
        while (currentNode != end) {
            ListNode next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        start.next = end;
        return prev;
    }
}
