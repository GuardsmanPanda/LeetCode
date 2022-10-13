package Problem2000;

import Types.ListNode;

public class Problem2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode cur = head, work = head.next.next;
        while (work != null) {
            work = work.next;
            if (work != null) {
                work = work.next;
                cur = cur.next;
            }
        }
        cur.next = cur.next.next;
        return head;
    }
}
