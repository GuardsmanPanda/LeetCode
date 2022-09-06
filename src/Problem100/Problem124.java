package Problem100;

import Types.TreeNode;

public class Problem124 {
    public int maxPathSum(TreeNode root) {
        fillMaxPathSum(root);
        return maxPathSum;
    }
    private int maxPathSum = Integer.MIN_VALUE;
    private int fillMaxPathSum(TreeNode node) {
        if (node == null) return 0;
        int left = fillMaxPathSum(node.left);
        int right = fillMaxPathSum(node.right);
        maxPathSum = Math.max(maxPathSum, node.val+left+right);
        int maxSide = Math.max(left, right);
        return Math.max(0, maxSide+node.val);
    }
}
