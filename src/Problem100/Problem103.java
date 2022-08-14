package Problem100;

import Types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        boolean left = true;
        while (!nodes.isEmpty()) {
            List<TreeNode> newNodes = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            for (int i = nodes.size() - 1; i >= 0; i--) {
                TreeNode node = nodes.get(i);
                if (node.left != null && node.right != null) {
                    newNodes.add(left ? node.left : node.right);
                    newNodes.add(left ? node.right : node.left);
                } else if (node.left != null) newNodes.add(node.left);
                else if (node.right != null) newNodes.add(node.right);
                result.add(node.val);
            }
            output.add(result);
            nodes = newNodes;
            left = !left;
        }
        return output;
    }
}
