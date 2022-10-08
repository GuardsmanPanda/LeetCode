package Problem600;

import Types.TreeNode;

public class Problem623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        if (d == 2) {
            TreeNode tmp = root.left;
            root.left = new TreeNode(v);
            root.left.left = tmp;
            tmp = root.right;
            root.right = new TreeNode(v);
            root.right.right = tmp;
        } else {
            addOneRow(root.left, v, d-1);
            addOneRow(root.right, v, d-1);
        }
        return root;
    }
}
