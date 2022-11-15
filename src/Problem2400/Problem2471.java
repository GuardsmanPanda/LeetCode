package Problem2400;

import Types.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem2471 {
    public int minimumOperations(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int[] mapping = new int[100_001];
        queue.add(root);
        int result = 0;
        while (queue.size() > 0) {
            List<Integer> level = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                level.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            int[] items = level.stream().mapToInt(i -> i).toArray();
            level.sort(Integer::compareTo);
            for (int i = 0; i < level.size(); i++) {
                mapping[level.get(i)] = i;
            }
            boolean[] visited = new boolean[items.length];
            for (int item : items) {
                int pos = mapping[item];
                int count = -1;
                while (!visited[pos]) {
                    visited[pos] = true;
                    pos = mapping[items[pos]];
                    count++;
                }
                result += Math.max(0, count);
            }
        }
        return result;
    }
}
