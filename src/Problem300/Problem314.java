package Problem300;

import Types.TreeNode;

import java.util.*;

public class Problem314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        return getMappedOrder(root, 0, 0, new HashMap<>())
                .entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(e -> e.getValue()
                        .stream()
                        .sorted(Comparator.comparingInt(a -> a[0]))
                        .map(a -> a[1])
                        .toList()
                )
                .toList();
    }

    private HashMap<Integer, List<int[]>> getMappedOrder(TreeNode node, int depth, int pos, HashMap<Integer, List<int[]>> map) {
        if (node == null) {
            return map;
        }
        map.computeIfAbsent(pos, k -> new ArrayList<>()).add(new int[]{depth, node.val});
        map = getMappedOrder(node.left, depth + 1, pos - 1, map);
        map = getMappedOrder(node.right, depth + 1, pos + 1, map);
        return map;
    }
}
