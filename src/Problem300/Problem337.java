package Problem300;

import Types.TreeNode;

public class Problem337 {
    public int rob(TreeNode root) {
        return getRobValue(root)[0];
    }

    private int[] getRobValue(TreeNode node) {
        if (node == null) return new int[2];
        int[] left = getRobValue(node.left), right = getRobValue(node.right);
        int max = Math.max(left[1]+right[1]+node.val, left[0]+right[0]);
        left[1] = left[0]+right[0];
        left[0] = max;
        return left;
    }
}
