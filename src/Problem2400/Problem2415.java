package Problem2400;

import Types.TreeNode;

import java.util.ArrayDeque;

public class Problem2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        queue.addFirst(root);
        int level = 0, size = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (level % 2 == 1) {
                nodes.addFirst(node);
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }

            if (--size == 0) {
                while (!nodes.isEmpty()) {
                    TreeNode n1 = nodes.removeFirst();
                    TreeNode n2 = nodes.removeLast();
                    int temp = n1.val;
                    n1.val = n2.val;
                    n2.val = temp;
                }
                size = queue.size();
                level++;
            }
        }
        return root;
    }
}
