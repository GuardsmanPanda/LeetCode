package Problem2200;

import Types.TreeNode;

public class Problem2236 {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
