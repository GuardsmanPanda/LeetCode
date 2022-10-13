package Problem600;

import Types.TreeNode;

import java.util.ArrayDeque;
import java.util.HashSet;

public class Problem653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        HashSet<Integer> numberSet = new HashSet<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.removeFirst();
            if (numberSet.contains(k-node.val)) return true;
            numberSet.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }
}
