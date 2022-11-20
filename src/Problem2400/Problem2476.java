package Problem2400;

import Types.TreeNode;

import java.util.List;
import java.util.TreeSet;

public class Problem2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        addNodes(root, set);
        return queries.stream().map(q -> {
            Integer floor = set.floor(q), ceil = set.ceiling(q);
            return List.of(floor == null ? -1 : floor, ceil == null ? -1 : ceil);
        }).toList();
    }

    private void addNodes(TreeNode node, TreeSet<Integer> set) {
        if (node != null) {
            set.add(node.val);
            addNodes(node.left, set);
            addNodes(node.right, set);
        }
    }
}
