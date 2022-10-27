package Problem2200;

import Types.TreeNode;

public class Problem2265 {
    public int averageOfSubtree(TreeNode root) {
        return avgCount(root)[2];
    }

    private int[] avgCount(TreeNode root) {
        if (root == null) return new int[] {0, 0, 0};
        int[] left = avgCount(root.left);
        int[] right = avgCount(root.right);
        left[0] += right[0] + root.val;
        left[1] += right[1] + 1;
        left[2] += right[2] + (left[0] / left[1] == root.val ? 1 : 0);
        return left;
    }
}
