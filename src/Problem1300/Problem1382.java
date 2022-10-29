package Problem1300;

import Types.TreeNode;

import java.util.Arrays;

public class Problem1382 {
    private static final int[] values = new int[10001];
    private static int size = 0;

    public TreeNode balanceBST(TreeNode root) {
        size = 0;
        addNode(root);
        return buildTree(0, --size);
    }

    private void addNode(TreeNode node) {
        if (node == null) {
            return;
        }
        addNode(node.left);
        values[size++] = node.val;
        addNode(node.right);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(values[mid]);
        root.left = buildTree(start, mid - 1);
        root.right = buildTree(mid + 1, end);
        return root;
    }
}
