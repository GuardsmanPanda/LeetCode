package Problem1300;

import Types.TreeNode;

public class Problem1372 {
    public int longestZigZag(TreeNode root) {
        return getLength(root, true, -1);
    }

    private int getLength(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            return length;
        }
        if (isLeft) {
            return Math.max(getLength(node.left, true, 0), getLength(node.right, false, length + 1));
        } else {
            return Math.max(getLength(node.left, true, length + 1), getLength(node.right, false, 0));
        }
    }
}
