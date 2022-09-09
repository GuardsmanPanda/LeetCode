package Problem1200;

import Types.ImmutableListNode;

import java.util.ArrayDeque;

public class Problem1265 {
    public void printLinkedListInReverse(ImmutableListNode head) {
        ArrayDeque<ImmutableListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.addFirst(head);
            head = head.getNext();
        }
        while (stack.size() > 0) {
            stack.removeFirst().printValue();
        }
    }
}
