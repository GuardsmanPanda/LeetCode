package Problem;

import Types.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) queue.add(list);
        }
        if (queue.size() == 0) return null;
        ListNode head = queue.remove();
        if (head.next != null) queue.add(head.next);
        ListNode lastNode = head;
        while (queue.size() > 0) {
            ListNode newNode = queue.remove();
            lastNode.next = newNode;
            if (newNode.next != null) queue.add(newNode.next);
            lastNode = newNode;
        }
        return head;
    }
}
