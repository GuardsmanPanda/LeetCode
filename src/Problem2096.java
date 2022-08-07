public class Problem2096 {
    record TreeNode(int val, TreeNode left, TreeNode right) {}

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = getLCA(root, startValue, destValue);
        StringBuilder p1 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();
        getPath(lca, startValue, p1);
        getPath(lca, destValue, p2);
        int length = p1.length();
        p1.setLength(0);
        p1.append("U".repeat(length)).append(p2);
        return p1.toString();
    }

    private boolean getPath(TreeNode node, int target, StringBuilder path) {
        if (node == null || node.val == target) {
            return node != null;
        }
        path.append("L");
        if (getPath(node.left, target, path)) {
            return true;
        }
        path.setLength(path.length() - 1);
        path.append("R");
        if (getPath(node.right, target, path)) {
            return true;
        }
        path.setLength(path.length() - 1);
        return false;
    }

    private TreeNode getLCA(TreeNode node, int val1, int val2) {
        if (node == null) {
            return null;
        }
        if (node.val == val1 || node.val == val2) {
            return node;
        }
        TreeNode left = getLCA(node.left, val1, val2);
        TreeNode right = getLCA(node.right, val1, val2);
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }
}
