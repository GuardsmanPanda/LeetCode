package Problem400;

import Types.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem429 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return  new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (queue.size() > 0) {
            int levelSize = queue.size();
            List<Integer> values = new ArrayList<>(levelSize);
            while (levelSize-- > 0) {
                Node current = queue.removeFirst();
                values.add(current.val);
                for (Node child : current.children)
                    queue.addLast(child);
            }
            result.add(values);
        }
        return result;
    }
}
