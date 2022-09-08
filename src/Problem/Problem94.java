package Problem;

import Types.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) return output;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.addFirst(node);
                node = node.left;
            }
            node = stack.removeFirst();
            output.add(node.val);
            node = node.right;
        }
        return output;
    }
}
