package Problem300;

import Types.ListNode;

public class Problem328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddStart = head, evenStart = head.next;
        ListNode odd = oddStart, even = oddStart.next;
        ListNode current = even.next;
        boolean evenNode = false;
        while (current != null) {
            if (evenNode) {
                even.next = current;
                even = current;
            } else {
                odd.next = current;
                odd = current;
            }
            evenNode = !evenNode;
            current = current.next;
        }
        even.next = null;
        odd.next = evenStart;
        return oddStart;
    }
}
