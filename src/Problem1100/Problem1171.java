package Problem1100;

import Types.ListNode;

import java.util.Map;

public class Problem1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new java.util.HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        int sum = 0;
        while (head != null) {
            sum += head.val;
            if (map.containsKey(sum)) {
                // remove all nodes between map.get(sum) and head
                int tempSum = sum;
                ListNode temp = map.get(sum).next;
                while (temp != head) {
                    tempSum += temp.val;
                    map.remove(tempSum);
                    temp = temp.next;
                }
                map.get(sum).next = head.next;
            } else {
                map.put(sum, head);
            }
            head = head.next;
        }
        return dummy.next;
    }
}
