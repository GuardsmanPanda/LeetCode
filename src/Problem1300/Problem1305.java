package Problem1300;

import Types.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root1 != null) {
            queue.addLast(root1);
        }
        if (root2 != null) {
            queue.addLast(root2);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            result.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        result.sort(Integer::compareTo);
        return result;
    }
}
