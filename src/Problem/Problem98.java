package Problem;

import Types.TreeNode;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        return validateTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateTree(TreeNode node, long min, long max) {
        if (node == null || node.val >= max || node.val <= min) {
            return node == null;
        }
        return validateTree(node.left, min, node.val) && validateTree(node.right, node.val, max);
    }
}
