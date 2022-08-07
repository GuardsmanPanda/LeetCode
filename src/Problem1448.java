public class Problem1448 {
    public int goodNodes(TreeNode root) {
        return getGoodCount(root, Integer.MIN_VALUE);
    }

    public int getGoodCount(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int goodCount = node.val >= max ? 1 : 0;
        goodCount += getGoodCount(node.left, Math.max(max, node.val));
        goodCount += getGoodCount(node.right, Math.max(max, node.val));
        return goodCount;
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
