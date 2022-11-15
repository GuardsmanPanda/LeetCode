package Problem200;

import Types.TreeNode;

public class Problem222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        TreeNode left = root, right = root;
        while (right != null) {
            right = right.right;
            left = left.left;
            height++;
        }
        if (left == null) return (1 << height) - 1;
        return countNodes(root.left)  + countNodes(root.right) + 1;
    }
}
