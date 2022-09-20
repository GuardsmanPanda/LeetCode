package Problem;

import Types.ListNode;

import java.util.ArrayDeque;

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        boolean carry = false;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null) val += l1.val;
            if (l2 != null) val += l2.val;
            if (carry) {
                carry = false;
                val++;
            }
            if (val > 9) carry = true;
            result.addLast(val%10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry) result.addLast(1);
        ListNode node = new ListNode(result.removeLast());
        while (!result.isEmpty()) {
            ListNode newNode = new ListNode(result.removeLast());
            newNode.next = node;
            node= newNode;
        }

        return node;
    }
}
