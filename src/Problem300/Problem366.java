package Problem300;

import Types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        insert(root, result);
        return result;
    }

    private int insert(TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return -1;
        }
        int left = insert(node.left, result);
        int right = insert(node.right, result);
        int level = Math.max(left, right) + 1;
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        return level;
    }
}
