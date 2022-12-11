package Problem800;

import Types.TreeNode;

import java.util.ArrayDeque;

public class Problem872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.add(root1);
        stack2.add(root2);
        while (stack1.size() > 0 && stack2.size() > 0) {
            TreeNode leaf1 = stack1.removeFirst();
            while (leaf1.left != null || leaf1.right != null) {
                if (leaf1.left == null || leaf1.right == null)
                    leaf1 = leaf1.left == null ? leaf1.right : leaf1.left;
                else {
                    stack1.addFirst(leaf1.right);
                    leaf1 = leaf1.left;
                }
            }
            TreeNode leaf2 = stack2.removeFirst();
            while (leaf2.left != null || leaf2.right != null) {
                if (leaf2.left == null || leaf2.right == null)
                    leaf2 = leaf2.left == null ? leaf2.right : leaf2.left;
                else {
                    stack2.addFirst(leaf2.right);
                    leaf2 = leaf2.left;
                }
            }
            if (leaf1.val != leaf2.val) return false;
        }
        return stack1.size() == stack2.size();
    }
}
