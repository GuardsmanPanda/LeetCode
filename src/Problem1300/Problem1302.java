package Problem1300;

import Types.TreeNode;

public class Problem1302 {
    private int level = 0, sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        findSum(root, 0);
        return sum;
    }

    private void findSum(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > this.level) {
            this.level = level;
            this.sum = 0;
        }
        if (level == this.level) {
            this.sum += node.val;
        }
        findSum(node.left, level + 1);
        findSum(node.right, level + 1);
    }
}
