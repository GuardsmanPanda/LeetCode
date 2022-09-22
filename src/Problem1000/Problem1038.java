package Problem1000;

import Types.TreeNode;

public class Problem1038 {
    public TreeNode bstToGst(TreeNode root) {
        convert(root, 0);
        return root;
    }

    private int convert(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        node.val += convert(node.right, sum);
        return convert(node.left, node.val);
    }
}
