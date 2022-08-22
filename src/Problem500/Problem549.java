package Problem500;

import Types.TreeNode;

public class Problem549 {
    private int maxFound = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        genMaxFound(root, 0, -1_000_000);
        return maxFound;
    }

    private int genMaxFound(TreeNode node, int curMax, int curVal) {
        curMax = node.val == curVal + 1 ? curMax + 1 : 1;
        maxFound = Math.max(maxFound, curMax);
        TreeNode left = node.left;
        TreeNode right = node.right;

        int lowerMax = 1;
        if (left != null && left.val < node.val) {
            int tmp = genMaxFound(left, 0, -1_000_000);
            if (left.val + 1 == node.val) {
                lowerMax = tmp + 1;
            }
        }
        if (right != null && right.val < node.val) {
            int tmp = genMaxFound(right, 0, -1_000_000);
            if (right.val + 1 == node.val) {
                lowerMax = Math.max(lowerMax, tmp + 1);
            }
        }
        System.out.println("node.val = " + node.val + ", lowerMax = " + lowerMax + ", curMax = " + curMax);
        maxFound = Math.max(maxFound, lowerMax);
        if (left != null && left.val >= node.val) {
            genMaxFound(left, Math.max(lowerMax, curMax), node.val);
        }
        if (right != null && right.val >= node.val) {
            genMaxFound(right, Math.max(lowerMax, curMax), node.val);
        }
        return lowerMax;
    }
}
