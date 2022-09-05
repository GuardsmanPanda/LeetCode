package Problem1600;

import Types.TreeNode;

import java.util.ArrayDeque;

public class Problem1602 {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            size--;
            if (node == u) {
                if (size == 0) return null;
                return queue.remove();
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (size == 0) size = queue.size();
        }
        return null;
    }
}
