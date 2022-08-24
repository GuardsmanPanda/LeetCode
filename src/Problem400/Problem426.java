package Problem400;

import Types.Node;

import java.util.ArrayList;
import java.util.List;

public class Problem426 {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> tmp = new ArrayList<>();
        genList(root, tmp);
        for (int i = 1; i < tmp.size(); i++) {
            Node prev = tmp.get(i - 1);
            Node cur = tmp.get(i);
            prev.right = cur;
            cur.left = prev;
        }
        Node head = tmp.get(0);
        Node tail = tmp.get(tmp.size() - 1);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void genList(Node node, List<Node> list) {
        if (node == null) {
            return;
        }
        genList(node.left, list);
        list.add(node);
        genList(node.right, list);
    }
}
