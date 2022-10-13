package Problem1600;

import java.util.ArrayDeque;

public class Problem1628 {
    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    };

    class ValueNode extends Node {
        int val;
        public ValueNode(int val) {
            this.val = val;
        }
        public int evaluate() {
            return val;
        }
    };

    class computeNode extends Node {
        char op;
        Node left, right;
        public computeNode(char op, Node left, Node right) {
            this.op = op;
            this.left = left;
            this.right = right;
        }
        public int evaluate() {
            int leftVal = left.evaluate();
            int rightVal = right.evaluate();
            return switch (op) {
                case '+' -> leftVal + rightVal;
                case '-' -> leftVal - rightVal;
                case '*' -> leftVal * rightVal;
                case '/' -> leftVal / rightVal;
                default -> 0;
            };
        }
    };

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            ArrayDeque<Node> stack = new ArrayDeque<>();
            for (String s : postfix) {
                if (s.length() == 1 && "+-*/".contains(s)) {
                    Node right = stack.removeLast();
                    Node left = stack.removeLast();
                    stack.addLast(new computeNode(s.charAt(0), left, right));
                } else {
                    stack.addLast(new ValueNode(Integer.parseInt(s)));
                }
            }
            return stack.removeLast();
        }
    };
}
