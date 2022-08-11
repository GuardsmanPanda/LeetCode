package Problem100;

import java.util.IdentityHashMap;
import java.util.Map;

public class Problem138 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Map<Node, Node> oldToNew = new IdentityHashMap<>();
        oldToNew.put(head, newHead);
        Node cur = newHead;
        while (head != null) {
            Node tmp = head;
            cur.random = head.random != null ? oldToNew.computeIfAbsent(head.random, k -> new Node(tmp.random.val)) : null;
            cur.next = head.next != null ? oldToNew.computeIfAbsent(head.next, k -> new Node(tmp.next.val)) : null;
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
