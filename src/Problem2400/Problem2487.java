package Problem2400;

import Types.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Problem2487 {
    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int max = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            max = Math.max(max, list.get(i));
            list.set(i, max);
        }
        ListNode dummy = new ListNode(0);
        cur = dummy;
        for (Integer value : list) {
            if (value <= head.val) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
