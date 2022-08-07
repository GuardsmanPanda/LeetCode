import java.util.HashMap;
import java.util.Map;

public class Problem437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> found = new HashMap<>();
        found.put(0L, 1);
        return dfs(root, found, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> found, long sum, long target) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int res = found.getOrDefault(sum - target, 0);
        found.compute(sum, (k, v) -> v == null ? 1 : v + 1);
        res += dfs(root.left, found, sum, target);
        res += dfs(root.right, found, sum, target);
        found.compute(sum, (k, v) -> v == null ? 0 : v - 1);
        return res;
    }


    public static class TreeNode {
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
