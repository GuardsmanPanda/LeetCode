package Problem1400;

import Types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem1469 {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        fillLonely(root, result);
        return result;
    }

    private boolean fillLonely(TreeNode node, List<Integer> lonely) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        boolean left = fillLonely(node.left, lonely);
        boolean right = fillLonely(node.right, lonely);
        if (left && !right) {
            lonely.add(node.left.val);
        }
        if (!left && right) {
            lonely.add(node.right.val);
        }
        return true;
    }
}
