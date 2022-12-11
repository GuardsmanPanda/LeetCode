package Problem1300;

import Types.TreeNode;

public class Problem1339 {
    private long max = 0;
    public int maxProduct(TreeNode root) {
        long total = getSum(root, 0);
        getSum(root, total);
        return (int)(max % 1000000007);
    }

    private int getSum(TreeNode node, long sum) {
        if (node == null) return 0;
        int left = getSum(node.left, sum);
        max = Math.max(max, left * (sum - left));
        int right = getSum(node.right, sum);
        max = Math.max(max, right * (sum - right));
        return left + right + node.val;
    }
}
