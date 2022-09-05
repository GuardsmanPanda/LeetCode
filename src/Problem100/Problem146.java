package Problem100;

import java.util.HashMap;
import java.util.Map;

public class Problem146 {
    class LRUCache {
        private class DoubleLinkNode {
            public int val;
            public final int key;
            public DoubleLinkNode next;
            public DoubleLinkNode prev;

            public DoubleLinkNode(int key, int value) {
                val = value;
                this.key = key;
            }
        }

        private final Map<Integer, DoubleLinkNode> keyMap = new HashMap<>();
        private final int max;
        private int size = 0;
        private DoubleLinkNode first;
        private DoubleLinkNode last;

        public LRUCache(int capacity) {
            max = capacity;
        }

        public int get(int key) {
            DoubleLinkNode valNode = keyMap.get(key);
            if (valNode == null) return -1;
            moveNodetoFront(valNode);
            return valNode.val;
        }

        public void put(int key, int value) {
            DoubleLinkNode node = new DoubleLinkNode(key, value);
            if (keyMap.containsKey(key)) {
                keyMap.get(key).val = value;
                moveNodetoFront(keyMap.get(key));
                return;
            }

            if (size == 0) {
                first = node;
                last = node;
            } else {
                node.next = first;
                first.prev = node;
                first = node;
            }
            size++;
            if (size > max) { //remove last node if over capacity.
                DoubleLinkNode removeNode = last;
                last = last.prev;
                last.next = null;
                keyMap.remove(removeNode.key);
                size--;
            }
            keyMap.put(key, node);
        }

        private void moveNodetoFront(DoubleLinkNode node) {
            if (first != node) {
                node.prev.next = node.next;
                if (node != last) node.next.prev = node.prev;
                else last = node.prev;
                node.prev = null;
                node.next = first;
                first.prev = node;
                first = node;
            }
        }
    }
}
