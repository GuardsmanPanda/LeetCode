package Problem200;

import Types.TreeNode;

public class Problem298 {
    public int longestConsecutive(TreeNode root) {
        return solve(root, 0, 0);
    }

    private int solve(TreeNode node, int last, int length) {
        if (node == null) {
            return length;
        }
        length = node.val == last + 1 ? length + 1 : 1;
        return Math.max(length, Math.max(solve(node.left, node.val, length), solve(node.right, node.val, length)));
    }
}
