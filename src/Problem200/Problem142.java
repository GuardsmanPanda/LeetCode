package Problem200;

public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            System.out.println("test");
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode fromStart = head;
        while (fromStart != slow) {
            fromStart = fromStart.next;
            slow = slow.next;
        }
        return fromStart;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
