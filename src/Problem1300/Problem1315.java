package Problem1300;

import Types.TreeNode;

public class Problem1315 {
    public int sumEvenGrandparent(TreeNode root) {
        return getEvenGrandParentSum(root, false, false);
    }

    private int getEvenGrandParentSum(TreeNode node, boolean evenParent, boolean evenGrandParent) {
        if (node == null) {
            return 0;
        }
        int sum = evenGrandParent ? node.val : 0;
        sum += getEvenGrandParentSum(node.left, node.val % 2 == 0, evenParent);
        sum += getEvenGrandParentSum(node.right, node.val % 2 == 0, evenParent);
        return sum;
    }
}
