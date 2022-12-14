package Problem100;

import Types.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        nodes.sort(Comparator.comparingInt(o -> o.val));
        ListNode start = nodes.get(0);
        ListNode cur = start;
        for (int i = 1; i < nodes.size(); i++) {
            cur.next = nodes.get(i);
            cur = cur.next;
        }
        cur.next = null;
        return start;
    }
}
