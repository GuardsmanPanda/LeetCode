package Problem1800;

import Types.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Problem1836 {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();
        ListNode node = head;
        while (node != null) {
            count.compute(node.val, (k, v) -> v == null ? 1 : v + 1);
            node = node.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null) {
            if (count.get(head.val) == 1) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
