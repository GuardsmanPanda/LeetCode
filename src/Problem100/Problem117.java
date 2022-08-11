package Problem100;

public class Problem117 {
    public Node connect(Node root) {
        Node orig = root;
        while (root != null) {
            Node first = null, current = null, process = root;
            while (process != null) {
                if (process.left != null) {
                    if (first == null) {
                        first = process.left;
                    } else {
                        current.next = process.left;
                    }
                    current = process.left;
                }
                if (process.right != null) {
                    if (first == null) {
                        first = process.right;
                    } else {
                        current.next = process.right;
                    }
                    current = process.right;
                }
                process = process.next;
            }
            root = first;
        }
        return orig;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
