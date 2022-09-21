package Problem2100;

import Types.ListNode;

public class Problem2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (head != null) {
            if (head.val == 0) {
                head = head.next;
                continue;
            }
            int sum = 0;
            while (head != null && head.val != 0) {
                sum += head.val;
                head = head.next;
            }
            current.next = new ListNode(sum);
            current = current.next;
        }
        return result.next;
    }
}
