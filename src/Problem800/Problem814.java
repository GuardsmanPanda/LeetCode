package Problem800;

import Types.TreeNode;

public class Problem814 {
    public TreeNode pruneTree(TreeNode root) {
        int val = pruneTheTree(root);
        return val == 0 ? null : root;
    }
    private int pruneTheTree(TreeNode node) {
        if (node == null) return 0;
        int left = pruneTheTree(node.left);
        int right = pruneTheTree(node.right);
        if (left == 0) node.left = null;
        if (right == 0) node.right = null;
        return left+right+node.val;
    }
}
