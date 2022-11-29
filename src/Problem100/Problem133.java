package Problem100;


import java.util.*;

public class Problem133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        ArrayDeque<Node> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        Map<Node, Node> nodeMap = new HashMap<>();
        Node result = new Node(node.val);
        nodeMap.put(node, result);
        q2.add(result);
        q1.add(node);

        while (q1.size() > 0) {
            Node n1 = q1.removeFirst(), n2 = q2.removeFirst();
            for (Node n : n1.neighbors) {
                if (!nodeMap.containsKey(n)) {
                    q1.addLast(n);
                    Node n3 = new Node(n.val);
                    q2.addLast(n3);
                    nodeMap.put(n, n3);
                }
                n2.neighbors.add(nodeMap.get(n));
            }
        }
        return result;
    }
}
