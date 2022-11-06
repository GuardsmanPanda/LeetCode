package Problem2400;

import Types.TreeNode;


public class Problem2458 {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length + 1];
        return ans;
    }

    public int traverse(TreeNode node, int[] ans) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left, ans);
        int right = traverse(node.right, ans);


        return Math.max(left, right) + 1;
    }
}
