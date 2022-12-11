package Problem1500;

import Types.Node;

import java.util.ArrayDeque;

public class Problem1597 {
    public Node expTree(String s) {
        ArrayDeque<Character> opsStack = new ArrayDeque<>();
        ArrayDeque<Node> nodeStack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                nodeStack.addFirst(new Node(c));
            } else if (c == '(') {
                opsStack.addFirst(c);
            } else if (c == ')') {
                while (opsStack.peekFirst() != '(') {
                    Node right = nodeStack.removeFirst();
                    Node left = nodeStack.removeFirst();
                    nodeStack.addFirst(new Node(opsStack.removeFirst(), left, right));
                }
                opsStack.removeFirst();
            } else {
                while (!opsStack.isEmpty() && opsStack.peekFirst() != '(' && opsStack.peekFirst() != ')') {
                    char c1 = opsStack.peekFirst();
                    if (c1 != '*' && c1 != '/' && c != '+' && c != '-') {
                        break;
                    }
                    Node right = nodeStack.removeFirst();
                    Node left = nodeStack.removeFirst();
                    nodeStack.addFirst(new Node(opsStack.removeFirst(), left, right));
                }
                opsStack.addFirst(c);
            }
        }
        while (!opsStack.isEmpty()) {
            Node right = nodeStack.removeFirst();
            Node left = nodeStack.removeFirst();
            nodeStack.addFirst(new Node(opsStack.removeFirst(), left, right));
        }
        return nodeStack.removeFirst();
    }
}
