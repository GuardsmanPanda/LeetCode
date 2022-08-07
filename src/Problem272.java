import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingDouble(i -> -Math.abs(i - target)));
        dfs(root, k, queue);
        return queue.stream().toList();
    }

    private void dfs(TreeNode node, int k, PriorityQueue<Integer> res) {
        if (node == null) {
            return;
        }
        dfs(node.left, k, res);
        res.add(node.val);
        if (res.size() > k) {
            res.remove();
        }
        dfs(node.right, k, res);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
