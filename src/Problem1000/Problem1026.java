package Problem1000;

import Types.TreeNode;

public class Problem1026 {
    public int maxAncestorDiff(TreeNode root) {
        return getMaxDiff(root, root.val, root.val);
    }

    public int getMaxDiff(TreeNode node, int min, int max) {
        if (node == null) return 0;
        int diff = Math.max(Math.abs(min-node.val), Math.abs(max-node.val));
        int left = getMaxDiff(node.left, Math.min(node.val, min), Math.max(max, node.val));
        int right = getMaxDiff(node.right, Math.min(node.val, min), Math.max(max, node.val));
        return Math.max(diff, Math.max(left, right));
    }
}
